package com.skyjoo.neweast.biz.datadic.service;

import java.util.List;

import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;

/**
 * �����ֵ仺�����
 * @author lxh
 * @version 2014-11-3 ����10:47:04
 */
public interface CommDatadicCacheService {

	/**
	 * ����������ȡ������ֵ�����
	 * @param groupName
	 * @return ��ȡ�����ͷ��ؿռ���
	 */
	public List<CommDatadic> getCommDatadicsByGroupName(String groupName);
	
	/**
	 * ����������ȡ������ֵ�����
	 * @param groupName
	 * @return ��ȡ�����ͷ��ؿռ���
	 */
	public List<CommDatadic> getCommDatadicsByGroupName(EnumDatadicGroupName groupName);
	
}
