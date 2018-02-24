package com.skyjoo.neweast.biz.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.dao.SystemUserDAO;
import com.skyjoo.neweast.biz.system.dao.SystemUserRoleDAO;
import com.skyjoo.neweast.biz.system.domain.SystemUser;
import com.skyjoo.neweast.biz.system.domain.SystemUserRole;
import com.skyjoo.neweast.biz.system.service.SystemUserService;

@Service
public class SystemUserServiceImpl extends BaseManager implements
		SystemUserService {
	
	@Autowired
	private SystemUserDAO systemUserDao;
	@Autowired
	private SystemUserRoleDAO systemUserRoleDao;
	@Autowired
	private MessageDigest passwordMessageDigest;
	
	@Override
	public SystemUser getSystemUserByLoginName(String loginName) {
		return systemUserDao.getSystemUserByLoginName(loginName);
	}

	@Override
	public int eidtSystemUser(SystemUser systemUser,List<Long> roles) {
        if(roles != null) {
            systemUserRoleDao.removeUserRoleByUserId(systemUser.getId());
	        for (Long roleId : roles) {
	            SystemUserRole ur = new SystemUserRole();
	            ur.setRoleId(roleId);
	            ur.setUserId(systemUser.getId());
	            ur.setOperator(systemUser.getOperator());
	            systemUserRoleDao.addUserRole(ur);
	        }
        }
		return systemUserDao.updateSystemUser(systemUser);
	}

	@Override
	public SystemUser getSystemUserById(Long userId) {
        return systemUserDao.getSystemUserById(userId);
	}

	@Override
	public List<SystemUser> getSystemUsers() {
        return systemUserDao.getSystemUsers();
	}

	@Override
	public Long addSystemUser(SystemUser systemUser, List<Long> roles) {
		String password = passwordMessageDigest.digest(systemUser.getPassword());
		systemUser.setPassword(password);
        Long userId = systemUserDao.addSystemUser(systemUser);
        for (Long roleId : roles) {
            SystemUserRole ur = new SystemUserRole();
            ur.setRoleId(roleId);
            ur.setUserId(userId);
            ur.setOperator(systemUser.getOperator());
            systemUserRoleDao.addUserRole(ur);
        }
        return userId;
	}

	@Override
	public int removeSystemUser(Long systemUserId) {
        systemUserRoleDao.removeUserRoleByUserId(systemUserId);
        return systemUserDao.removeSystemUser(systemUserId);
	}

	@Override
	public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page) {
        return systemUserDao.getPaginatedSystemUser(page);
	}

	@Override
	public int updateOwnInfo(SystemUser ownInfo) {
		String password = passwordMessageDigest.digest(ownInfo.getPassword());
		ownInfo.setPassword(password);
        return systemUserDao.updateOwnInfo(ownInfo);
	}

	@Override
	public boolean checkLoginNameUnique(SystemUser systemUser) {
        boolean isExist = false;
        if (StringUtil.isNotBlank(systemUser.getLoginName())) {
            int count = systemUserDao.checkLoginNameUnique(systemUser);
            if (count >= 1) {
                isExist = true;
            }
        }
        return isExist;
	}

	@Override
	public boolean checkTelAndMobile(String tel, String mobile) {
		return StringUtil.isBlank(tel) && StringUtil.isBlank(mobile);
	}

	@Override
	public int initPassword(SystemUser systemUser) {
		return systemUserDao.initPassword(systemUser);
	}

}
