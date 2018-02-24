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
	 * ����id��ȡϵͳ����
	 */
    @Override
    public SystemFunction getSystemFunctionById(Long id) {
        return systemFunctionDao.getSystemFunctionById(id);
    }
    /**
     * ���ݸ�pid��ȡ�Ӳ˵��б�
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
	 * �����ϵͳ����
	 */
	@Override
	public Long addSystemFunction(SystemFunction systemFunction) {
		systemFunction.setOperator(this.getLoginName());
        return systemFunctionDao.addSystemFunction(systemFunction);
	}
	
	/**
	 * �޸�ϵͳ����
	 */
	@Override
	public Integer editSystemFunction(SystemFunction systemFunction) {
		systemFunction.setOperator(this.getLoginName());
        return systemFunctionDao.editSystemFunction(systemFunction);
	}

	/**
	 * ɾ��ϵͳ����
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
	 * ���ʱ��ȡ�ϼ�Ŀ¼
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
        // ȡ�����е���Ŀ��Ϣ
        List<SystemFunction> allmenus = systemFunctionDao.getAllSystemFunction();
        setMenus(0l, menus, allmenus);
        
        return menus;
	}
	
	/**
     * ����Ӳ˵��б�
     * @param list ����б�
     * @param pid ��id
     * @param id �޸�ʱ�ж�Ҫ�޸ĵ�ԭĿ¼
     * @param psign ��֧����
     * @return
     * @author wm
     * @date 2014-11-4
     */
    private List<Map<String, Object>> getSonFunNames(List<Map<String, Object>> list, Long pid,
                                                     Long id, String psign) {
    	if (pid.longValue() == 0L) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 0);
            map.put("name", "��Ŀ¼");
            list.add(map);
        }
        List<SystemFunction> list_fun = systemFunctionDao.getSystemFunctionByPid(pid);
      
        for (int i = 0; i < list_fun.size(); i++) {
            SystemFunction fun = list_fun.get(i);
            if (fun.getId().longValue() != id.longValue()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", fun.getId());
                String str = "";
                if (psign.endsWith("��")) {
                    str = psign.substring(0, psign.lastIndexOf("��")) + ";&nbsp; ";
                } else if (psign.endsWith("��")) {
                    str = psign.substring(0, psign.lastIndexOf("��")) + "��";
                }
                if (i == list_fun.size() - 1
                    || (i + 2 == list_fun.size() && list_fun.get(i + 1).getId().longValue() == id
                        .longValue())) {
                    str += "��";
                } else {
                    str += "��";
                }

                map.put("name", str + fun.getName());
                list.add(map);
                getSonFunNames(list, fun.getId(), id, str);
            }
        }
        return list;
    }
    
    /**
     * �ݹ����������״list����
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
     * ���ݸ���ID ȡ�øø��������Ӧ����������
     * @param list ���е���Ŀ��Ϣ�б�
     * @param pid ����ID
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
