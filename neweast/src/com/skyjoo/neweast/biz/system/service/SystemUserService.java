package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

public interface SystemUserService {
	/**
	 * 根据用户登录名获取系统用户
	 * @param loginId
	 * @return
	 */
	public SystemUser getSystemUserByLoginName(String loginName);

	/**
	 * 更新系统用户
	 * @param systemUser
	 */
	public int eidtSystemUser(SystemUser systemUser, List<Long> roles);
	
	public SystemUser getSystemUserById(Long userId);
	
	public List<SystemUser> getSystemUsers();
	
	public Long addSystemUser(SystemUser systemUser,List<Long> roles);
	
	public int removeSystemUser(Long systemUserId);
	
	/* @interface model: 查询所有SystemUser结果集,返回分页对象的集合 */
    public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page);
    
    /*@interface model: 当前用户修改自己信息*/
    public int updateOwnInfo(SystemUser ownInfo);

    public boolean checkLoginNameUnique(SystemUser systemUser);

    public boolean checkTelAndMobile(String tel,String mobile);
    
    /**
     *初始化密码
     * @param password
     * @param userId
     */
    public int initPassword(SystemUser systemUser);

}
