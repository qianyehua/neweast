package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;

/**
 * ��Ա�˻�
 * @author wm
 * @version 2014-11-10 
 */
public interface UserAccountDAO {
	
	/**
	 * �����Ա����
	 * @param account
	 * @return
	 */
	public Long insertUserAccount(UserAccount account);

	/**
	 * ��ҳ��ѯ
	 * @param query
	 */
	public void selectUserAccountPage(UserAccountQuery query);
	
	/**
	 * ����id��ȡ��Ա�˻�
	 * @param email
	 * @return
	 */
	public UserAccount selectUserAccountById(Long id);
	
	/**
	 * �����˺Ż�ȡ
	 * @param stockAccount
	 * @return
	 */
	public UserAccount selectUserAccountByStockAccount(String stockAccount);
	
	/**
	 * �����˺Ż�ȡ
	 * @param stockAccount
	 * @return
	 */
	public UserAccount selectUserAccountByFundAccount(String fundAccount);
	
	/**
	 * �޸Ļ�Ա<br>
	 * @param account
	 * @return
	 */
	public int updateUserAccount(UserAccount account);
	
	/**
     * ��ȡ��������ID
     * @param 
     * @return
     */
    public List<Long> getAllSellerId();
    
    /**
     * ��ȡ���Сʱ�����������������
     * @param 
     * @return
     */
    public List<Long> getChangeSellerId();
    

}
