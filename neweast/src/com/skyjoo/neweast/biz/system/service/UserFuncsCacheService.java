package com.skyjoo.neweast.biz.system.service;

import java.util.List;
import java.util.Map;

/**
 * 当前系统的权限缓存
 * @author lxh
 * @version 2014-11-6 下午02:14:51
 */
public interface UserFuncsCacheService {

	/**
	 * 根据ID获取该用户的权限偏移后的IDs
	 * @param userId
	 * @return
	 */
	public List<Integer> getUserFunctionIds(Long userId);
	
	/**
	 * 根据URL获取偏移后的权限ID
	 * @param url
	 * @return
	 */
	public Integer getFunctionOffsetId(String url);

	/**
	 * 获取偏移量
	 * @return
	 */
	public Long getOffset();
	
	/**
	 * 获取所有权限的URL-ID映射关系
	 * @return
	 */
	public Map<String, Integer> getFunctionMap();
	
}
