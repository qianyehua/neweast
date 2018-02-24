package com.skyjoo.neweast.biz.system.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;

public interface SystemFunctionService {
	
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
     * 添加菜单
     * @author wm
     */
    public Long addSystemFunction(SystemFunction systemFunction);
    
    /**
     * 修改菜单
     * @param systemFunction
     * @return
     * @author wm
     */
    public Integer editSystemFunction(SystemFunction systemFunction);
    
   /**
    * 删除菜单
    * @param id
    * @return
    * @author wm
    */
    public Integer removeSystemFunction(Long id);
    
    /**
     * 获得所有目录（下拉列表显示）
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getSystemFunctionSelNames();
    
    /**
     * 获得功能修改可选择目录（下拉列表显示），该功能不可选择到当前功能及其子功能下
     * @param id 当前功能id
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getSystemFunctionEditNames(Long id);

    /**
     * 获取可用状态的功能项总数
     * @return
     * @author wm
     */
    public int getFunctionCount();
    
    public List<SystemFunction> getMenus();
    
    public Long getParentId(Long id);
}
