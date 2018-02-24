package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemRoleFunction;
/**
 * 系统功能角色关系数据对象
 * 
 * @author wangyf
 * @version $Id: SystemRoleFunctionDao.java,v 0.1 2010-4-27 下午03:02:40 wangyf Exp $
 */
public interface SystemRoleFunctionDAO {

    /**
     * 新增功能角色关系
     * 
     * @param systemRoleFunction
     * @return
     */
    public Long addRoleFunction(SystemRoleFunction systemRoleFunction);

    /**
     * 移除角色所有功能
     * 
     * @param roleId
     * @return
     */
    public int removeRoleFunction(Long roleId);

    /**
     * 根据角色ID查询角色所有功能
     * 
     * @param roleId
     * @return
     */
    public List<SystemRoleFunction> getRoleFuncsByRoleId(Long roleId);
}
