package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemRole;

public interface SystemRoleDAO {

	/**
	 * �����û�ID��ȡ���û���Ȩ��
	 * @param loginId
	 * @return
	 */
	public List<SystemRole> getSystemRolesByUserID(Long userID);
	
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
    public Long addRole(SystemRole systemRole);

    /**
     * �޸Ľ�ɫ
     * 
     * @return
     */
    public int editRole(SystemRole systemRole);

    /**
     * ɾ����ɫ
     * 
     * @return
     */
    public int removeRole(Long id);

    /**
     * ����ID��ѯ��ɫ��Ϣ
     * 
     * @param id
     * @return
     */
    public SystemRole getRoleById(Long id);
    
    /**
     * ��ȡ���н�ɫ
     * 
     * @return
     */
    public List<SystemRole> getRoles();

}
