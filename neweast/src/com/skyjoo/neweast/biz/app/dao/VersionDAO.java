package com.skyjoo.neweast.biz.app.dao;

import java.util.List;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;

public interface VersionDAO {
	
	/**
	 * 获取版本列表
	 */
	public List<VersionInfo> getVersionList();
	
	/**
	 * 根据id获取版本详细信息
	 */
	public VersionInfo getVersionById(Long id);
	
	/**
	 * 修改版本信息
	 */
	public Integer updateVersion(VersionInfo versionInfo);
}
