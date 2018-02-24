package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

public interface SystemUserDAO {

	/**
	 * �����û���¼����ȡϵͳ�û�
	 * @param loginId
	 * @return
	 */
	public SystemUser getSystemUserByLoginName(String loginName);

	/**
	 * ����ϵͳ�û�
	 * @param systemUser
	 * @return
	 */
	public int updateSystemUser(SystemUser systemUser);
	
	public List<SystemUser> getSystemUsers();
	
	public long addSystemUser(SystemUser systemUser);

    public int removeSystemUser(Long systemUserId);
    
    public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page);

    public SystemUser getSystemUserById(Long userId);

    public int updateOwnInfo(SystemUser ownInfo);

    public int checkLoginNameUnique(SystemUser systemUser);

    /**
     *��ʼ������
     * @param password
     * @param userId
     */
    public int initPassword(SystemUser systemUser);
}
