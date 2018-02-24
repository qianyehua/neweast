package com.skyjoo.neweast.biz.system.service;

import java.util.List;
import java.util.Map;

/**
 * ��ǰϵͳ��Ȩ�޻���
 * @author lxh
 * @version 2014-11-6 ����02:14:51
 */
public interface UserFuncsCacheService {

	/**
	 * ����ID��ȡ���û���Ȩ��ƫ�ƺ��IDs
	 * @param userId
	 * @return
	 */
	public List<Integer> getUserFunctionIds(Long userId);
	
	/**
	 * ����URL��ȡƫ�ƺ��Ȩ��ID
	 * @param url
	 * @return
	 */
	public Integer getFunctionOffsetId(String url);

	/**
	 * ��ȡƫ����
	 * @return
	 */
	public Long getOffset();
	
	/**
	 * ��ȡ����Ȩ�޵�URL-IDӳ���ϵ
	 * @return
	 */
	public Map<String, Integer> getFunctionMap();
	
}
