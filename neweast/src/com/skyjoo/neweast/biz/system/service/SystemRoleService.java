package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemRole;

/**
 * 系统角色管理
 * @author lxh
 * @version 2014-10-30 上午09:35:40
 */
public interface SystemRoleService {
	
	/**
     * 分页获取角色
     * 
     * @param page
     * @return
     */
    public Paginable<SystemRole> getRoles(Paginable<SystemRole> page);

    /**
     * 新增角色
     * 
     * @return
     */
    public Long addRole(SystemRole systemRole, List<Long> functions);

    /**
     * 修改角色
     * 
     * @return
     */
    public boolean editRole(SystemRole systemRole, List<Long> functions);

    /**
     * 删除角色
     * 
     * @return
     */
    public boolean removeRole(Long id);

    /**
     * 根据ID查询角色信息
     * 
     * @param id
     * @return
     */
    public SystemRole getRoleById(Long id);

    /**
     * 获得JSON数组形式的系统功能数据
     * @return
     */
    public JSONArray getSystemFunctionJson(Long roleId);
    
    /**
     * 获取所有角色
     * 
     * @return
     */
    public List<SystemRole> getRoles();
}
