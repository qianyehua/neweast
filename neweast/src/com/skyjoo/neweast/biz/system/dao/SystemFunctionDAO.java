package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;


public interface SystemFunctionDAO {

	/**
	 * 根据用户角色ID号获取系统功能 
	 * @param roleIDs
	 * @return
	 */
	public List<SystemFunction> getSystemFunctionsByRoleIDs(List<Long> roleIDs);
	
    /**
     * 根据id获得菜单
     * @param id
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public SystemFunction getSystemFunctionById(Long id);
    
    /**
     * 根据父id获取子菜单列表
     * @param pid 父id
     * @return
     * @author wangming
     * @date 2014-11-3
     */
    public List<SystemFunction> getSystemFunctionByPid(Long pid);
    
    /**
     * 取得所有的功能类目信息
     * @return
     * @author xiasq
     * @date 2010-10-18
     */
    public List<SystemFunction> getAllSystemFunction();
    
    /**
     * 根据父id获取子菜单目录列表
     * @param pid
     * @return
     * @author chenxi
     * @date 2010-4-19
     */
    public List<SystemFunction> getSystemFunctionMenusByPid(Long pid);
    
    /**
     * 添加菜单
     * @param systemFunction
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public Long addSystemFunction(SystemFunction systemFunction);
    
    /**
     * 修改菜单
     * @param systemFunction
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public Integer editSystemFunction(SystemFunction systemFunction);
    
   /**
    * 删除菜单
    * @param id
    * @return
    * @author chenxi
    * @date 2010-4-16
    */
    public Integer removeSystemFunction(SystemFunction systemFunction);
    
    /**
     * 获取可用状态的功能项总数
     * 
     * @return
     */
    public Integer getFunctionCount();
    
    /**
     * 获取该功能被多少角色使用
     * @param funId
     * @return
     * @author chenxi
     * @date 2010-5-10
     */
    public Integer getFunCountInFunRose(Long funId);
    
    public Long getParentId(Long id);

}
