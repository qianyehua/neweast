package com.skyjoo.neweast.biz.system.dao;

import java.util.List;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;


public interface SystemFunctionDAO {

	/**
	 * �����û���ɫID�Ż�ȡϵͳ���� 
	 * @param roleIDs
	 * @return
	 */
	public List<SystemFunction> getSystemFunctionsByRoleIDs(List<Long> roleIDs);
	
    /**
     * ����id��ò˵�
     * @param id
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public SystemFunction getSystemFunctionById(Long id);
    
    /**
     * ���ݸ�id��ȡ�Ӳ˵��б�
     * @param pid ��id
     * @return
     * @author wangming
     * @date 2014-11-3
     */
    public List<SystemFunction> getSystemFunctionByPid(Long pid);
    
    /**
     * ȡ�����еĹ�����Ŀ��Ϣ
     * @return
     * @author xiasq
     * @date 2010-10-18
     */
    public List<SystemFunction> getAllSystemFunction();
    
    /**
     * ���ݸ�id��ȡ�Ӳ˵�Ŀ¼�б�
     * @param pid
     * @return
     * @author chenxi
     * @date 2010-4-19
     */
    public List<SystemFunction> getSystemFunctionMenusByPid(Long pid);
    
    /**
     * ��Ӳ˵�
     * @param systemFunction
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public Long addSystemFunction(SystemFunction systemFunction);
    
    /**
     * �޸Ĳ˵�
     * @param systemFunction
     * @return
     * @author chenxi
     * @date 2010-4-16
     */
    public Integer editSystemFunction(SystemFunction systemFunction);
    
   /**
    * ɾ���˵�
    * @param id
    * @return
    * @author chenxi
    * @date 2010-4-16
    */
    public Integer removeSystemFunction(SystemFunction systemFunction);
    
    /**
     * ��ȡ����״̬�Ĺ���������
     * 
     * @return
     */
    public Integer getFunctionCount();
    
    /**
     * ��ȡ�ù��ܱ����ٽ�ɫʹ��
     * @param funId
     * @return
     * @author chenxi
     * @date 2010-5-10
     */
    public Integer getFunCountInFunRose(Long funId);
    
    public Long getParentId(Long id);

}
