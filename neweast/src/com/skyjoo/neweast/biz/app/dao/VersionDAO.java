package com.skyjoo.neweast.biz.app.dao;

import java.util.List;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;

public interface VersionDAO {
	
	/**
	 * ��ȡ�汾�б�
	 */
	public List<VersionInfo> getVersionList();
	
	/**
	 * ����id��ȡ�汾��ϸ��Ϣ
	 */
	public VersionInfo getVersionById(Long id);
	
	/**
	 * �޸İ汾��Ϣ
	 */
	public Integer updateVersion(VersionInfo versionInfo);
}
