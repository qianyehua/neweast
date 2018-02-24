package com.skyjoo.neweast.biz.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.dao.SystemFunctionDAO;
import com.skyjoo.neweast.biz.system.dao.SystemRoleDAO;
import com.skyjoo.neweast.biz.system.dao.SystemRoleFunctionDAO;
import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.domain.SystemRole;
import com.skyjoo.neweast.biz.system.domain.SystemRoleFunction;
import com.skyjoo.neweast.biz.system.service.SystemRoleService;

@Service
public class SystemRoleServiceImpl extends BaseManager implements
		SystemRoleService {
	@Autowired
	private SystemRoleDAO systemRoleDao;
	@Autowired
	private SystemFunctionDAO systemFunctionDao;
	@Autowired
	private SystemRoleFunctionDAO systemRoleFunctionDao;

	@Override
	public Paginable<SystemRole> getRoles(Paginable<SystemRole> page) {
		return systemRoleDao.getRoles(page);
	}
	
	/**
	 * 添加角色
	 */
	@Override
	public Long addRole(SystemRole systemRole, List<Long> functions) {
		Long roleId = systemRoleDao.addRole(systemRole);
		if (roleId == null){
			return roleId;
		}
		for (Long func : functions){
			SystemRoleFunction rf = new SystemRoleFunction();
			rf.setFunctionId(func);
			rf.setOperator(getLoginName());
			rf.setRoleId(roleId);
			systemRoleFunctionDao.addRoleFunction(rf);
		}
		return roleId;
	}
	
	/**
	 * 修改角色
	 */
	@Override
	public boolean editRole(SystemRole systemRole, List<Long> functions) {
		Long roleId = systemRole.getId();
        systemRoleFunctionDao.removeRoleFunction(roleId);
        for (Long func : functions) {
            SystemRoleFunction rf = new SystemRoleFunction();
            rf.setFunctionId(func);
            rf.setOperator(getLoginName());
            rf.setRoleId(roleId);
            systemRoleFunctionDao.addRoleFunction(rf);
        }
        int num = systemRoleDao.editRole(systemRole);
        return num == 1 ? true : false;
	}

	@Override
	public boolean removeRole(Long id) {
		systemRoleFunctionDao.removeRoleFunction(id);
        int num = systemRoleDao.removeRole(id);
        return num == 1 ? true : false;
	}

	@Override
	public SystemRole getRoleById(Long id) {
		return systemRoleDao.getRoleById(id);
	}

	@Override
	public JSONArray getSystemFunctionJson(Long roleId) {
		List<SystemRoleFunction> roleFuncs = new ArrayList<SystemRoleFunction>();
        boolean hasFunc = false;
        if (roleId != null) {
            roleFuncs = systemRoleFunctionDao.getRoleFuncsByRoleId(roleId);
        }
        if (roleFuncs.size() > 0) {
            hasFunc = true;
        }
        JSONArray data = new JSONArray();
        // 取得所有的系统功能
        List<SystemFunction> allFunctions = systemFunctionDao.getAllSystemFunction();
        setData(0l, data, hasFunc, roleFuncs, allFunctions);
        return data;
	}

	@Override
	public List<SystemRole> getRoles() {
		return systemRoleDao.getRoles();
	}
	
	/**
     * 递归遍历构造树状JSON数组
     * 
     * @param pid 父节点ID
     * @param data 子节点JSON数组
     * @param hasFunc 当前角色是否已有权限
     * @param roleFuncs 当前角色已有的权限列表
     */
    private void setData(Long pid, JSONArray data, boolean hasFunc,
                         List<SystemRoleFunction> roleFuncs, List<SystemFunction> allFunctions) {
    	List<SystemFunction> parentFuncs = getFuncListByParentId(allFunctions, pid);
        for (SystemFunction func : parentFuncs) {
            JSONObject parent = new JSONObject();
            JSONArray data2 = new JSONArray();
            parent.accumulate("id", func.getId());
            parent.accumulate("text", func.getName());
            parent.accumulate("value", func.getId());
            parent.accumulate("showcheck", true);
            parent.accumulate("complete", true);
            if (hasFunc) {
                for (SystemRoleFunction rf : roleFuncs) {
                    if (rf.getFunctionId().longValue() == func.getId().longValue()) {
                        parent.accumulate("checkstate", true);
                        break;
                    }
                }
            } else {
                parent.accumulate("checkstate", false);
            }
            parent.accumulate("isexpand", true);
            Long pid2 = func.getId();
            List<SystemFunction> list = getFuncListByParentId(allFunctions, pid2);
            if (list == null || list.size() == 0) {
                parent.accumulate("hasChildren", false);
                parent.accumulate("ChildNodes", null);
                data.add(parent);
                continue;
            } else {
                setData(pid2, data2, hasFunc, roleFuncs, allFunctions);
            }
            parent.accumulate("hasChildren", true);
            parent.accumulate("ChildNodes", data2.toString());
            data.add(parent);
        }
    }
    
    /**
     * 取得父功能Id下的功能列表
     * @param allFunctions
     * @param pid
     * @return
     */
    private List<SystemFunction> getFuncListByParentId(List<SystemFunction> allFunctions, Long pid){
    	if (allFunctions == null) {
			return null;
		}
    	
    	List<SystemFunction> newFunclist = new ArrayList<SystemFunction>();
    	for (SystemFunction sysFunc : allFunctions) {
            if (sysFunc.getParentId() != null && sysFunc.getParentId().equals(pid)) {
            	newFunclist.add(sysFunc);
			}
		}
    	return newFunclist;
    }

	public void setSystemRoleDao(SystemRoleDAO systemRoleDao) {
		this.systemRoleDao = systemRoleDao;
	}

	public void setSystemFunctionDao(SystemFunctionDAO systemFunctionDao) {
		this.systemFunctionDao = systemFunctionDao;
	}

	public void setSystemRoleFunctionDao(SystemRoleFunctionDAO systemRoleFunctionDao) {
		this.systemRoleFunctionDao = systemRoleFunctionDao;
	}
}
