package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

public interface SystemUserService {
	/**
	 * �����û���¼����ȡϵͳ�û�
	 * @param loginId
	 * @return
	 */
	public SystemUser getSystemUserByLoginName(String loginName);

	/**
	 * ����ϵͳ�û�
	 * @param systemUser
	 */
	public int eidtSystemUser(SystemUser systemUser, List<Long> roles);
	
	public SystemUser getSystemUserById(Long userId);
	
	public List<SystemUser> getSystemUsers();
	
	public Long addSystemUser(SystemUser systemUser,List<Long> roles);
	
	public int removeSystemUser(Long systemUserId);
	
	/* @interface model: ��ѯ����SystemUser�����,���ط�ҳ����ļ��� */
    public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page);
    
    /*@interface model: ��ǰ�û��޸��Լ���Ϣ*/
    public int updateOwnInfo(SystemUser ownInfo);

    public boolean checkLoginNameUnique(SystemUser systemUser);

    public boolean checkTelAndMobile(String tel,String mobile);
    
    /**
     *��ʼ������
     * @param password
     * @param userId
     */
    public int initPassword(SystemUser systemUser);

}
