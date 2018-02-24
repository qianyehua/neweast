package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemUserRole;

/**
 * 用户角色关系MANAGER接口
 * 
 * @author wm
 * @version $Id: SystemUserRoleManager.java,v 0.1 2010-4-28 下午02:43:49 wangyf Exp $
 */
public interface SystemUserRoleService {

    /**
     * 根据用户ID查询用户的角色
     * 
     * @param userId
     * @return
     */
    public List<SystemUserRole> getUserRoleByUserId(Long userId);
    
    /**
     * 角色是否已经被使用
     * 
     * @param roleId
     * @return
     */
    public boolean isRoleUsed(Long roleId);
}
