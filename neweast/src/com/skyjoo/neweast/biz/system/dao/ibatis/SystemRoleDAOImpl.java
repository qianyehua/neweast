package com.skyjoo.neweast.biz.system.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.dao.SystemRoleDAO;
import com.skyjoo.neweast.biz.system.domain.SystemRole;

@Repository
@SuppressWarnings({"deprecation" })
public class SystemRoleDAOImpl extends BaseDaoiBatis implements SystemRoleDAO {

	private static String SQLMAP_SPACE = "SYSTEM_ROLE.";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemRole> getSystemRolesByUserID(Long userID) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getRolesByUserID", userID);
	}

	@Override
	public Paginable<SystemRole> getRoles(Paginable<SystemRole> page) {
		try{
			super.paginate(page, SQLMAP_SPACE+"getRolesCount", SQLMAP_SPACE+"getRoles");
			return page;
		}catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Long addRole(SystemRole systemRole) {
		return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE+"addRole", systemRole);
	}

	@Override
	public int editRole(SystemRole systemRole) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE+"editRole", systemRole);
	}

	@Override
	public int removeRole(Long id) {
		return this.getSqlMapClientTemplate().delete(SQLMAP_SPACE+"removeRole", id);
	}

	@Override
	public SystemRole getRoleById(Long id) {
		return (SystemRole) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getRoleById",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemRole> getRoles() {
		return (List<SystemRole>) this.getSqlMapClientTemplate().queryForList(
				SQLMAP_SPACE+"getAllRoles");
	}


}
