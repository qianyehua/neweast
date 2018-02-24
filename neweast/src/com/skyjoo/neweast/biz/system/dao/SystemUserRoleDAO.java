package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemUserRole;

/**
 * 用户角色关系数据对象
 * 
 * @author wangyf
 * @version $Id: SystemUserRoleDao.java,v 0.1 2010-4-27 下午03:03:23 wangyf Exp $
 */
public interface SystemUserRoleDAO {

    public List<SystemUserRole> getUserRoleByUserId(Long userId);

    public Long addUserRole(SystemUserRole systemUserRole);

    public int removeUserRoleByUserId(Long userId);

    public int getUserRoleByRoleId(Long roleId);
}
