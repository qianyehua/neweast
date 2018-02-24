package com.skyjoo.neweast.biz.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.system.dao.SystemUserRoleDAO;
import com.skyjoo.neweast.biz.system.domain.SystemUserRole;
import com.skyjoo.neweast.biz.system.service.SystemUserRoleService;
@Service
public class SystemUserRoleServiceImpl extends BaseManager implements SystemUserRoleService {

	@Autowired
    private SystemUserRoleDAO systemUserRoleDao;
	
    public void setSystemUserRoleDao(SystemUserRoleDAO systemUserRoleDao) {
        this.systemUserRoleDao = systemUserRoleDao;
    }

    public List<SystemUserRole> getUserRoleByUserId(Long userId) {
        return systemUserRoleDao.getUserRoleByUserId(userId);
    }

    public boolean isRoleUsed(Long roleId) {
        int count = systemUserRoleDao.getUserRoleByRoleId(roleId);
        return count == 0 ? false : true;
    }
}
