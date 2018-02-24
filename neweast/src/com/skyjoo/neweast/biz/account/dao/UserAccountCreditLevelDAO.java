/**
 * 
 */
package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;

/**
 * @author admin
 *
 */
public interface UserAccountCreditLevelDAO {
	
	/**
	 * 获取最新且已生效的帐号等级列表
	 */
	public List<UserAccountCreditLevel> getUACL();
	
	/**
	 * 获取最新未生效的帐号等级列表
	 */
	public List<UserAccountCreditLevel> getNewUACL();
	
	/**
	 * 获取版本号
	 */
	public Long getLevelVersionNumber();
	
	/**
	 * 获取下个交易日生效的等级数
	 */
	public int getNextLevelCount();
	
	/**
	 * 新增
	 */
	public Long insertLevel(UserAccountCreditLevel level);
	
	/**
	 * 获取最新的版本信用等级
	 */
	public List<UserAccountCreditLevel> getNewestUACL();
	
	/**
	 * 获取所有未生效的信用等级
	 */
	public List<UserAccountCreditLevel> getInvalidUACL();
	
	/**
	 * 获取版本号
	 */
	public Long getValidVersion();
	
	/**
	 * 更新版本号
	 */
	public int update(UserAccountCreditLevel level);

    /**
     *判断是否有新生效信用等级
     */
    public int isHasValidVersion();

}
