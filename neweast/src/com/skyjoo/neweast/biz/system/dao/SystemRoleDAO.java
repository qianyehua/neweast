package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemRole;

public interface SystemRoleDAO {

	/**
	 * 根据用户ID获取该用户的权限
	 * @param loginId
	 * @return
	 */
	public List<SystemRole> getSystemRolesByUserID(Long userID);
	
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
    public Long addRole(SystemRole systemRole);

    /**
     * 修改角色
     * 
     * @return
     */
    public int editRole(SystemRole systemRole);

    /**
     * 删除角色
     * 
     * @return
     */
    public int removeRole(Long id);

    /**
     * 根据ID查询角色信息
     * 
     * @param id
     * @return
     */
    public SystemRole getRoleById(Long id);
    
    /**
     * 获取所有角色
     * 
     * @return
     */
    public List<SystemRole> getRoles();

}
