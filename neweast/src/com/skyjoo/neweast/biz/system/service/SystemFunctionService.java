package com.skyjoo.neweast.biz.system.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;

public interface SystemFunctionService {
	
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
     * ��Ӳ˵�
     * @author wm
     */
    public Long addSystemFunction(SystemFunction systemFunction);
    
    /**
     * �޸Ĳ˵�
     * @param systemFunction
     * @return
     * @author wm
     */
    public Integer editSystemFunction(SystemFunction systemFunction);
    
   /**
    * ɾ���˵�
    * @param id
    * @return
    * @author wm
    */
    public Integer removeSystemFunction(Long id);
    
    /**
     * �������Ŀ¼�������б���ʾ��
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getSystemFunctionSelNames();
    
    /**
     * ��ù����޸Ŀ�ѡ��Ŀ¼�������б���ʾ�����ù��ܲ���ѡ�񵽵�ǰ���ܼ����ӹ�����
     * @param id ��ǰ����id
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getSystemFunctionEditNames(Long id);

    /**
     * ��ȡ����״̬�Ĺ���������
     * @return
     * @author wm
     */
    public int getFunctionCount();
    
    public List<SystemFunction> getMenus();
    
    public Long getParentId(Long id);
}
