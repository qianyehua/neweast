package com.skyjoo.neweast.biz.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.app.dao.VersionDAO;
import com.skyjoo.neweast.biz.app.domain.VersionInfo;
import com.skyjoo.neweast.biz.app.service.VersionService;
import com.skyjoo.neweast.biz.common.base.BaseManager;

@Service
public class VersionServiceImpl extends BaseManager implements VersionService {
    @Autowired
    private VersionDAO versionDAO;
    
    public List<VersionInfo> getVersionList(){
        return versionDAO.getVersionList();
    }
    
    public VersionInfo getVersionById(Long id){
        return versionDAO.getVersionById(id);
    }
    
    public Integer updateVersion(VersionInfo versionInfo){
        return versionDAO.updateVersion(versionInfo);
    }
}
