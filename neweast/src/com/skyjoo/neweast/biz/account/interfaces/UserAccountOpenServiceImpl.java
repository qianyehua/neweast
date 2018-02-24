package com.skyjoo.neweast.biz.account.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.wudadao.common.Result;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.account.dao.UserAccountCreditDAO;
import com.skyjoo.neweast.biz.account.dao.UserAccountDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.shop.dao.ShopDAO;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderDAO;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;
import com.skyjoo.wudadao.neweast.dto.UserAccountDTO;
import com.skyjoo.wudadao.neweast.interfaces.UserAccountOpenService;
import com.skyjoo.wudadao.weiguodao.dto.EnumCancelAccountResult;
@Deprecated
@Service("userAccountOpenService")
public class UserAccountOpenServiceImpl implements UserAccountOpenService {

    @Autowired
    private UserAccountDAO       userAccountDAO;
    @Autowired
    private UserAccountCreditDAO userAccountCreditDAO;
    @Autowired
    private TradeOrderDAO        tradeOrderDAO;
    @Autowired
    private ArtDAO               artDAO;
    @Autowired
    private ShopDAO              shopDAO;

    @Override
    public boolean openUserAccount(UserAccountDTO accountDTO) {
        UserAccount account = userAccountDAO.selectUserAccountByFundAccount(accountDTO.getFundAccount());
        if (account == null) {
            account = new UserAccount(accountDTO);
            account.setNickName(account.getRealName());
            Long id = userAccountDAO.insertUserAccount(account);
            if (id <= 0) {
                return false;
            }

            UserAccountCredit credit = new UserAccountCredit(id, 0L);
            id = userAccountCreditDAO.insertUserAccountCredit(credit);
            if (id == null || id == 0) {
                return false;
            }
        } else {
            account.setCountry(accountDTO.getCountry());
            account.setEmail(accountDTO.getEmail());
            account.setMobile(accountDTO.getMobile());
            account.setRealName(accountDTO.getRealName());
            account.setLicenseType(accountDTO.getLicenseType());
            account.setLicense(accountDTO.getLicense());
            account.setGender(accountDTO.getGender());
            account.setBirthday(accountDTO.getBirthday());
            account.setAccountType(accountDTO.getAccountType());
            if(StringUtil.isBlank(account.getNickName())){
                account.setNickName(accountDTO.getRealName());
            }
            
            int n = userAccountDAO.updateUserAccount(account);
            if (n == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Result<EnumCancelAccountResult> preCancelUserAccount(String stockAccount) {
        Result<EnumCancelAccountResult> result = new Result<EnumCancelAccountResult>(false);
        UserAccount account = userAccountDAO.selectUserAccountByStockAccount(stockAccount);
        if (account == null) {
            return result.setResult(EnumCancelAccountResult.STOCK_ACCOUNT_IS_NOT_EXIST);
        }

        int count = tradeOrderDAO.selectTradeOrderLimitCountForCancel(account.getId());
        if (count > 0) {
            return result.setResult(EnumCancelAccountResult.STOCK_ACCOUNT_HAVE_ORDER);
        }

        count = artDAO.selectArtLimitCountForCancel(account.getId());
        if (count > 0) {
            return result.setResult(EnumCancelAccountResult.STOCK_ACCOUNT_HAVE_ART);
        }

        return result.setSuccess(true);
    }

    @Override
    public Result<EnumCancelAccountResult> cancelUserAccount(String stockAccount) {
        Result<EnumCancelAccountResult> result = preCancelUserAccount(stockAccount);
        if (!result.isSuccess()) {
            return result;
        }

        UserAccount account = userAccountDAO.selectUserAccountByStockAccount(stockAccount);
        Shop shop = shopDAO.selectShopByAccountId(account.getId());
        if (shop != null && shop.isNormal()) {
            shop.setStatus(EnumShopStatus.CLOSED);
            shopDAO.updateShop(shop);
        }

        account.setStatus(EnumUserAccountStatus.CANCELED.getValue());
        userAccountDAO.updateUserAccount(account);
        return result;
    }
    
    

}
