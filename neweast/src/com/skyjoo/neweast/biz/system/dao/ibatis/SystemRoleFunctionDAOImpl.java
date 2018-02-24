package com.skyjoo.neweast.biz.system.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.system.dao.SystemRoleFunctionDAO;
import com.skyjoo.neweast.biz.system.domain.SystemRoleFunction;

@Repository
public class SystemRoleFunctionDAOImpl extends BaseDaoiBatis implements SystemRoleFunctionDAO {

    @SuppressWarnings("deprecation")
	public Long addRoleFunction(SystemRoleFunction systemRoleFunction) {
        return (Long) this.getSqlMapClientTemplate().insert("SystemRoleFunction.addRoleFuncs",
            systemRoleFunction);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<SystemRoleFunction> getRoleFuncsByRoleId(Long roleId) {
        return this.getSqlMapClientTemplate().queryForList(
            "SystemRoleFunction.getRoleFuncsByRoleId", roleId);
    }

    @SuppressWarnings("deprecation")
	public int removeRoleFunction(Long roleId) {
        return this.getSqlMapClientTemplate().delete("SystemRoleFunction.removeRoleFuncsByRoleId",
            roleId);
    }
}
