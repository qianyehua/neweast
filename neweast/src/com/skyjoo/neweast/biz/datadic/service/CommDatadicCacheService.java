package com.skyjoo.neweast.biz.datadic.service;

import java.util.List;

import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;

/**
 * 数据字典缓存管理
 * @author lxh
 * @version 2014-11-3 上午10:47:04
 */
public interface CommDatadicCacheService {

	/**
	 * 根据组名获取缓存的字典数据
	 * @param groupName
	 * @return 获取不到就返回空集合
	 */
	public List<CommDatadic> getCommDatadicsByGroupName(String groupName);
	
	/**
	 * 根据组名获取缓存的字典数据
	 * @param groupName
	 * @return 获取不到就返回空集合
	 */
	public List<CommDatadic> getCommDatadicsByGroupName(EnumDatadicGroupName groupName);
	
}
