package com.skyjoo.neweast.biz.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.account.dao.UserAccountDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;
import com.skyjoo.neweast.biz.account.service.UserAccountService;
import com.skyjoo.neweast.biz.common.base.BaseManager;

@Service
public class UserAccountServiceImpl extends BaseManager implements
		UserAccountService {
	
	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Override
	public void getUserAccountPage(UserAccountQuery query) {
		userAccountDAO.selectUserAccountPage(query);
	}
    
	@Override
	public UserAccount getUserAccountById(Long id) {
		return userAccountDAO.selectUserAccountById(id);
	}
}
