package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;

/**
 * 会员账户
 * @author wm
 * @version 2014-11-10 
 */
public interface UserAccountDAO {
	
	/**
	 * 插入会员数据
	 * @param account
	 * @return
	 */
	public Long insertUserAccount(UserAccount account);

	/**
	 * 分页查询
	 * @param query
	 */
	public void selectUserAccountPage(UserAccountQuery query);
	
	/**
	 * 根据id获取会员账户
	 * @param email
	 * @return
	 */
	public UserAccount selectUserAccountById(Long id);
	
	/**
	 * 根据账号获取
	 * @param stockAccount
	 * @return
	 */
	public UserAccount selectUserAccountByStockAccount(String stockAccount);
	
	/**
	 * 根据账号获取
	 * @param stockAccount
	 * @return
	 */
	public UserAccount selectUserAccountByFundAccount(String fundAccount);
	
	/**
	 * 修改会员<br>
	 * @param account
	 * @return
	 */
	public int updateUserAccount(UserAccount account);
	
	/**
     * 获取所有卖家ID
     * @param 
     * @return
     */
    public List<Long> getAllSellerId();
    
    /**
     * 获取半个小时内有信誉更变的卖家
     * @param 
     * @return
     */
    public List<Long> getChangeSellerId();
    

}
