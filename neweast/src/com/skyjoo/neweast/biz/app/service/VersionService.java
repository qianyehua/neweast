package com.skyjoo.neweast.biz.app.service;

import java.util.List;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;

public interface VersionService {
    /**
     * 获取版本列表
     */
    public List<VersionInfo> getVersionList();
    
    /**
     * 根据id获取版本信息
     */
    public VersionInfo getVersionById(Long id);
    
    /**
     * 更新版本信息
     */
    public Integer updateVersion(VersionInfo versionInfo);
}
