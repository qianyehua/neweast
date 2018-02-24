package com.skyjoo.neweast.biz.system.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.system.dao.SystemUserRoleDAO;
import com.skyjoo.neweast.biz.system.domain.SystemUserRole;

@Repository
@SuppressWarnings({"deprecation" })
public class SystemUserRoleDAOImpl extends BaseDaoiBatis implements SystemUserRoleDAO {

    public Long addUserRole(SystemUserRole systemUserRole) {
        return (Long) this.getSqlMapClientTemplate().insert("SystemUserRole.addUserRole",
            systemUserRole);
    }

    @SuppressWarnings("unchecked")
    public List<SystemUserRole> getUserRoleByUserId(Long userId) {
        return this.getSqlMapClientTemplate().queryForList("SystemUserRole.getUserRoleByUserId",
            userId);
    }

    public int removeUserRoleByUserId(Long userId) {
        return this.getSqlMapClientTemplate().delete("SystemUserRole.removeUserRoleByUserId",
            userId);
    }

    public int getUserRoleByRoleId(Long roleId) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(
            "SystemUserRole.getUserRoleByRoleId", roleId);
    }
}
