package com.skyjoo.neweast.biz.account.service;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;

/**
 * 会员账户管理
 */
public interface UserAccountService {
	
	/**
	 * 分页查询
	 * @param query
	 */
	public void getUserAccountPage(UserAccountQuery query);
	
	/**
	 * 根据id获取会员账户
	 * @param email
	 * @return
	 */
	public UserAccount getUserAccountById(Long id);
}
