/**
 * 
 */
package com.skyjoo.neweast.biz.account.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.account.dao.UserAccountCreditLevelDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditLevelService;

/**
 * @author wm
 */
@Service
public class UserAccountCreditLevelServiceImpl implements
		UserAccountCreditLevelService {

	@Autowired
	private UserAccountCreditLevelDAO creditLevelDAO;
	
	@Override
	public List<UserAccountCreditLevel> getUACL() {
		return creditLevelDAO.getUACL();
	}

	@Override
	public List<UserAccountCreditLevel> getNewUACL() {
		return creditLevelDAO.getNewUACL();
	}
	
	@Override
	public Long addNewLevel(Map< Integer, UserAccountCreditLevel> map) {
		Long version;
		if(creditLevelDAO.getNextLevelCount()==0){
			version=0l;
		}else{
			version = creditLevelDAO.getLevelVersionNumber()+1l;
		}
		Long count=0L;
		for(UserAccountCreditLevel level : map.values()){
			if(level!=null){
				level.setVersion(version);
				creditLevelDAO.insertLevel(level);
				count++;
			}
		}
		return count;
	}

	@Override
	public List<UserAccountCreditLevel> getNewestUACL() {
		return creditLevelDAO.getNewestUACL();
	}

	@Override
	public List<UserAccountCreditLevel> getInvalidUACL() {
		return creditLevelDAO.getInvalidUACL();
	}

	@Override
	public Long getValidVersion() {
		return creditLevelDAO.getValidVersion();
	}

	@Override
	public int update(UserAccountCreditLevel level) {
		return creditLevelDAO.update(level);
	}

    @Override
    public boolean isHasValidVersion() {
        boolean isHasValidVersion=false;
        if(creditLevelDAO.isHasValidVersion()>0){
            isHasValidVersion=true;
        }
        return isHasValidVersion;
    }

}