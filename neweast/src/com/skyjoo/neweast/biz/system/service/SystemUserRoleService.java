package com.skyjoo.neweast.biz.system.service;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemUserRole;

/**
 * �û���ɫ��ϵMANAGER�ӿ�
 * 
 * @author wm
 * @version $Id: SystemUserRoleManager.java,v 0.1 2010-4-28 ����02:43:49 wangyf Exp $
 */
public interface SystemUserRoleService {

    /**
     * �����û�ID��ѯ�û��Ľ�ɫ
     * 
     * @param userId
     * @return
     */
    public List<SystemUserRole> getUserRoleByUserId(Long userId);
    
    /**
     * ��ɫ�Ƿ��Ѿ���ʹ��
     * 
     * @param roleId
     * @return
     */
    public boolean isRoleUsed(Long roleId);
}
