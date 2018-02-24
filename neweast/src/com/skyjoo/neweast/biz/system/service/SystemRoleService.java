package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemRole;

/**
 * ϵͳ��ɫ����
 * @author lxh
 * @version 2014-10-30 ����09:35:40
 */
public interface SystemRoleService {
	
	/**
     * ��ҳ��ȡ��ɫ
     * 
     * @param page
     * @return
     */
    public Paginable<SystemRole> getRoles(Paginable<SystemRole> page);

    /**
     * ������ɫ
     * 
     * @return
     */
    public Long addRole(SystemRole systemRole, List<Long> functions);

    /**
     * �޸Ľ�ɫ
     * 
     * @return
     */
    public boolean editRole(SystemRole systemRole, List<Long> functions);

    /**
     * ɾ����ɫ
     * 
     * @return
     */
    public boolean removeRole(Long id);

    /**
     * ����ID��ѯ��ɫ��Ϣ
     * 
     * @param id
     * @return
     */
    public SystemRole getRoleById(Long id);

    /**
     * ���JSON������ʽ��ϵͳ��������
     * @return
     */
    public JSONArray getSystemFunctionJson(Long roleId);
    
    /**
     * ��ȡ���н�ɫ
     * 
     * @return
     */
    public List<SystemRole> getRoles();
}
