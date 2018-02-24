package com.skyjoo.neweast.biz.account.service;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;

/**
 * ��Ա�˻�����
 */
public interface UserAccountService {
	
	/**
	 * ��ҳ��ѯ
	 * @param query
	 */
	public void getUserAccountPage(UserAccountQuery query);
	
	/**
	 * ����id��ȡ��Ա�˻�
	 * @param email
	 * @return
	 */
	public UserAccount getUserAccountById(Long id);
}
