package com.skyjoo.neweast.biz.app.service;

import java.util.List;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;

public interface VersionService {
    /**
     * ��ȡ�汾�б�
     */
    public List<VersionInfo> getVersionList();
    
    /**
     * ����id��ȡ�汾��Ϣ
     */
    public VersionInfo getVersionById(Long id);
    
    /**
     * ���°汾��Ϣ
     */
    public Integer updateVersion(VersionInfo versionInfo);
}
