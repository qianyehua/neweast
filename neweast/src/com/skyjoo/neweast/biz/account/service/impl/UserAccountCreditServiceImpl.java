package com.skyjoo.neweast.biz.account.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.dao.UserAccountCreditDAO;
import com.skyjoo.neweast.biz.account.dao.UserAccountDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditLevelService;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditService;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

@Service
public class UserAccountCreditServiceImpl implements UserAccountCreditService {

	@Autowired
	private UserAccountCreditDAO userAccountCreditDAO;
	@Autowired
    private UserAccountDAO       userAccountDAO;
	@Autowired
	private UserAccountCreditLevelService  userAccountCreditLevelService;
	
	@Override
    public UserAccountCredit getByAccountIdAndType(Long accountId, EnumUserAccountType creditType) {
    	return userAccountCreditDAO.selectByAccountIdAndType(accountId, creditType.getValue());
	}

	@Override
	public Result<Integer> updateCreditLevelAll(EnumUserAccountType creditType) {
		return updateCreditLevel(userAccountDAO.getAllSellerId(), creditType);
	}

	@Override
	public Result<Integer> updateCreditLevelPart(EnumUserAccountType creditType) {
		return updateCreditLevel(userAccountDAO.getChangeSellerId(), creditType);
	}
	
	private Result<Integer> updateCreditLevel(List<Long> accountIds, EnumUserAccountType creditType) {
		Result<Integer> result = new Result<Integer>(true);
		if(CollectionUtils.isEmpty(accountIds)) {
			return result.setResult(0);
		}
        List<UserAccountCreditLevel> levelList = userAccountCreditLevelService.getUACL();
        List<UserAccountCredit> creditList = userAccountCreditDAO.selectByAccountIdsAndType(accountIds, creditType);
        
        Iterator<UserAccountCredit> iterator = creditList.iterator();
        while(iterator.hasNext()) {
        	UserAccountCredit credit = iterator.next();
        	long score = credit.getCreditScore();
        	
        	UserAccountCreditLevel nowLevel = null;
        	for (int i = 0; i < levelList.size() - 1; i++) {
        		UserAccountCreditLevel level1 = levelList.get(i);
        		UserAccountCreditLevel level2 = levelList.get(i + 1);
                if (score >= level1.getLowLimit() && score < level2.getLowLimit()) {
                	nowLevel = level1;
                	break;
                }
            }
        	
        	if(nowLevel == null) {
            	UserAccountCreditLevel topLevel = levelList.get(levelList.size() - 1);
            	if(score > topLevel.getLowLimit()) {
            		nowLevel = topLevel;
            	}
        	}
        	
        	if(nowLevel.getLevelNo().equals(credit.getCreditLevelNo())) {//不需要改
        		iterator.remove();
        	} else {
        		credit.setCreditLevelNo(nowLevel.getLevelNo());
        		credit.setCreditLevelName(nowLevel.getLevelName());
        	}
        }
        
        userAccountCreditDAO.batchUpdateUserAccountCredit(creditList);
        return result.setResult(creditList.size());
    }
	
	

}
