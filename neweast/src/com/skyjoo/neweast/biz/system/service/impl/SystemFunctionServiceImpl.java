package com.skyjoo.neweast.biz.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.system.dao.SystemFunctionDAO;
import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.service.SystemFunctionService;

@Service
public class SystemFunctionServiceImpl extends BaseManager implements SystemFunctionService {

	@Autowired
    private SystemFunctionDAO systemFunctionDao;
	
	/**
	 * 根据id获取系统功能
	 */
    @Override
    public SystemFunction getSystemFunctionById(Long id) {
        return systemFunctionDao.getSystemFunctionById(id);
    }
    /**
     * 根据父pid获取子菜单列表
     */
	@Override
	public List<SystemFunction> getSystemFunctionByPid(Long pid) {
		List<SystemFunction> list = systemFunctionDao.getSystemFunctionByPid(pid);
        for (SystemFunction fun : list) {
            if (systemFunctionDao.getFunCountInFunRose(fun.getId()) > 0) {
                fun.setCanDeleted(false);
            } else {
                fun.setCanDeleted(true);
            }
        }
        return list;
	}
	
	/**
	 * 提添加系统功能
	 */
	@Override
	public Long addSystemFunction(SystemFunction systemFunction) {
		systemFunction.setOperator(this.getLoginName());
        return systemFunctionDao.addSystemFunction(systemFunction);
	}
	
	/**
	 * 修改系统功能
	 */
	@Override
	public Integer editSystemFunction(SystemFunction systemFunction) {
		systemFunction.setOperator(this.getLoginName());
        return systemFunctionDao.editSystemFunction(systemFunction);
	}

	/**
	 * 删除系统功能
	 */
	@Override
	public Integer removeSystemFunction(Long id) {
		if (systemFunctionDao.getFunCountInFunRose(id) > 0) {
            log.debug("this function is used by rose!can not delete!");
            return 0;
        }
        SystemFunction systemFunction = new SystemFunction();
        systemFunction.setId(id);
        systemFunction.setOperator(getLoginName());
        return systemFunctionDao.removeSystemFunction(systemFunction);
	}
	/**
	 * 添加时获取上级目录
	 */
	@Override
	public List<Map<String, Object>> getSystemFunctionSelNames() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        return this.getSonFunNames(list, 0L, -1L, "");
	}
	
	@Override
	public List<Map<String, Object>> getSystemFunctionEditNames(Long id) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        return this.getSonFunNames(list, 0L, id, "");
	}

	@Override
	public int getFunctionCount() {
        return systemFunctionDao.getFunctionCount();
	}

	@Override
	public List<SystemFunction> getMenus() {
		List<SystemFunction> menus = new ArrayList<SystemFunction>();
        // 取得所有的类目信息
        List<SystemFunction> allmenus = systemFunctionDao.getAllSystemFunction();
        setMenus(0l, menus, allmenus);
        
        return menus;
	}
	
	/**
     * 获得子菜单列表
     * @param list 结果列表
     * @param pid 父id
     * @param id 修改时判断要修改的原目录
     * @param psign 分支符号
     * @return
     * @author wm
     * @date 2014-11-4
     */
    private List<Map<String, Object>> getSonFunNames(List<Map<String, Object>> list, Long pid,
                                                     Long id, String psign) {
    	if (pid.longValue() == 0L) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 0);
            map.put("name", "根目录");
            list.add(map);
        }
        List<SystemFunction> list_fun = systemFunctionDao.getSystemFunctionByPid(pid);
      
        for (int i = 0; i < list_fun.size(); i++) {
            SystemFunction fun = list_fun.get(i);
            if (fun.getId().longValue() != id.longValue()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", fun.getId());
                String str = "";
                if (psign.endsWith("┗")) {
                    str = psign.substring(0, psign.lastIndexOf("┗")) + ";&nbsp; ";
                } else if (psign.endsWith("┣")) {
                    str = psign.substring(0, psign.lastIndexOf("┣")) + "┃";
                }
                if (i == list_fun.size() - 1
                    || (i + 2 == list_fun.size() && list_fun.get(i + 1).getId().longValue() == id
                        .longValue())) {
                    str += "┗";
                } else {
                    str += "┣";
                }

                map.put("name", str + fun.getName());
                list.add(map);
                getSonFunNames(list, fun.getId(), id, str);
            }
        }
        return list;
    }
    
    /**
     * 递归遍历构造树状list数据
     * 
     */
    private void setMenus(Long pid, List<SystemFunction> menus, List<SystemFunction> allmenus) {
        List<SystemFunction> parentFuncs = getFunctionListByPid(allmenus, pid);
        if (parentFuncs == null || parentFuncs.size() == 0) {
            return;
        }

        for (SystemFunction func : parentFuncs) {
            List<SystemFunction> sonMenus = new ArrayList<SystemFunction>();
            Long pid2 = func.getId();
            List<SystemFunction> list = getFunctionListByPid(allmenus, pid2);
            if (list == null || list.size() == 0) {
                menus.add(func);
                continue;
            } else {
                setMenus(pid2, sonMenus, allmenus);
            }
            func.setSubfunctions(sonMenus);
            menus.add(func);
        }
    }
    
    /**
     * 根据父类ID 取得该父类下面对应的子类结果集
     * @param list 所有的类目信息列表
     * @param pid 父类ID
     * @return
     */
    private List<SystemFunction> getFunctionListByPid(List<SystemFunction> list, Long pid) {
    	if (list == null || list.size() == 0) {
            return null;
        }

        List<SystemFunction> sonMenus = new ArrayList<SystemFunction>();
        for (SystemFunction func : list) {
            if (func.getParentId().equals(pid)) {
                sonMenus.add(func);
            }
        }

        return sonMenus;
    }
	@Override
	public Long getParentId(Long id) {
		return systemFunctionDao.getParentId(id);
	}
}
