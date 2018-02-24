package com.skyjoo.neweast.biz.shop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.dao.UserAccountCreditDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.dao.ShopAuthApplyDAO;
import com.skyjoo.neweast.biz.shop.dao.ShopAuthApplyOrgDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApplyOrg;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;
import com.skyjoo.neweast.biz.shop.service.ShopAuthApplyService;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;

@Service
public class ShopAuthApplyServiceImpl implements ShopAuthApplyService {

	@Autowired
	private ShopAuthApplyDAO shopAuthApplyDAO;
	@Autowired
	private ShopAuthApplyOrgDAO shopAuthApplyOrgDAO;
	@Autowired
	private UserAccountCreditDAO userAccountCreditDAO;
	
	@Override
	public void getShopAuthApplyPage(ShopAuthApplyQuery query) {
		shopAuthApplyDAO.getShopAuthApplyPage(query);
	}

	@Override
	public ShopAuthApply getShopAuthApplyById(Long id) {
		ShopAuthApply apply = shopAuthApplyDAO.selectShopAuthApplyById(id);
		if(apply != null && apply.isCompany()) {
			apply.setApplyOrg(shopAuthApplyOrgDAO.selectShopAuthApplyOrgByApplyId(apply.getId()));
		}
		return apply;
	}

	@Override
	public CommResult auditShopAuthApply(ShopAuthApply apply, boolean success, String operator) {
		ShopAuthApply r_apply = shopAuthApplyDAO.selectShopAuthApplyById(apply.getId());
		if(success) {
			r_apply.setStatus(EnumShopAuthStatus.AUDIT_SUCCESS);
			r_apply.setMemo(null);
			userAccountCreditDAO.insertUserAccountCredit(new UserAccountCredit(r_apply.getAccountId(), EnumUserAccountType.SELLER.getValue(), 0L));
		} else {
			r_apply.setStatus(EnumShopAuthStatus.AUDIT_FAILED);
			r_apply.setMemo(apply.getMemo());
		}
		r_apply.setOperator(operator);
		shopAuthApplyDAO.updateShopAuthApply(r_apply);
		return new CommResult(true);
	}

    @Override
    public Result<ShopAuthApply> createShopAuthApply(ShopAuthApply apply) {
        Result<ShopAuthApply> result = new Result<ShopAuthApply>(true);
        ShopAuthApply r_apply = shopAuthApplyDAO.selectShopAuthApplyByLoginId(apply.getLoginId());
        if(r_apply != null) {
            return result.setResult(r_apply);
        }
        
        apply.setGmtApply(new Date());
        apply.setOperator("system");
        apply.setGmtApply(new Date());
        //apply.setStatus(EnumShopAuthStatus.AUDITING);
        
        Long id = shopAuthApplyDAO.insertShopAuthApply(apply);
        apply.setId(id);
        if(id>0){
            userAccountCreditDAO.insertUserAccountCredit(new UserAccountCredit(apply.getAccountId(), EnumUserAccountType.SELLER.getValue(), 0L));
        }
        
        return result.setResult(apply);
    }

}
