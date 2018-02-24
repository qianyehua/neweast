package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemRoleFunction;
/**
 * ϵͳ���ܽ�ɫ��ϵ���ݶ���
 * 
 * @author wangyf
 * @version $Id: SystemRoleFunctionDao.java,v 0.1 2010-4-27 ����03:02:40 wangyf Exp $
 */
public interface SystemRoleFunctionDAO {

    /**
     * �������ܽ�ɫ��ϵ
     * 
     * @param systemRoleFunction
     * @return
     */
    public Long addRoleFunction(SystemRoleFunction systemRoleFunction);

    /**
     * �Ƴ���ɫ���й���
     * 
     * @param roleId
     * @return
     */
    public int removeRoleFunction(Long roleId);

    /**
     * ���ݽ�ɫID��ѯ��ɫ���й���
     * 
     * @param roleId
     * @return
     */
    public List<SystemRoleFunction> getRoleFuncsByRoleId(Long roleId);
}
