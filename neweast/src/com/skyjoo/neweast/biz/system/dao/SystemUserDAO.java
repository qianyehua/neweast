package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

public interface SystemUserDAO {

	/**
	 * 根据用户登录名获取系统用户
	 * @param loginId
	 * @return
	 */
	public SystemUser getSystemUserByLoginName(String loginName);

	/**
	 * 更新系统用户
	 * @param systemUser
	 * @return
	 */
	public int updateSystemUser(SystemUser systemUser);
	
	public List<SystemUser> getSystemUsers();
	
	public long addSystemUser(SystemUser systemUser);

    public int removeSystemUser(Long systemUserId);
    
    public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page);

    public SystemUser getSystemUserById(Long userId);

    public int updateOwnInfo(SystemUser ownInfo);

    public int checkLoginNameUnique(SystemUser systemUser);

    /**
     *初始化密码
     * @param password
     * @param userId
     */
    public int initPassword(SystemUser systemUser);
}
