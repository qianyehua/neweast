package com.skyjoo.neweast.biz.system.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.system.dao.SystemUserDAO;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

@Repository
@SuppressWarnings("deprecation")
public class SystemUserDAOImpl extends BaseDaoiBatis implements SystemUserDAO {

	private static String SQLMAP_SPACE = "SYSTEM_USER.";
	 
	@Override
	public SystemUser getSystemUserByLoginName(String loginName) {
		return (SystemUser) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "getByLoginName", loginName);
	}

	@Override
	public int updateSystemUser(SystemUser systemUser) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", systemUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemUser> getSystemUsers() {
		return (List<SystemUser>) this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE +"getSystemUsers");
	}

	@Override
	public long addSystemUser(SystemUser systemUser) {
		return (Long)this.getSqlMapClientTemplate().insert(SQLMAP_SPACE +"addSystemUser", systemUser);
	}

	@Override
	public int removeSystemUser(Long systemUserId) {
		return this.getSqlMapClientTemplate().delete(SQLMAP_SPACE +"removeSystemUserByUserId", systemUserId);
	}

	@Override
	public Paginable<SystemUser> getPaginatedSystemUser(Paginable<SystemUser> page) {
        try
        {
            super.paginate(page, SQLMAP_SPACE +"getSystemUsersCount",
            			SQLMAP_SPACE +"getPaginatedSystemUser");
            System.out.println(page);
            return page;
        }catch(Exception e)
        {
           log.error(e.getStackTrace());
        }
        return null;
	}

	@Override
	public SystemUser getSystemUserById(Long userId) {
		return (SystemUser)this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getSystemUserByUserId",userId);
	}

	@Override
	public int updateOwnInfo(SystemUser ownInfo) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE +"updateOwnInfo",ownInfo);
	}

	@Override
	public int checkLoginNameUnique(SystemUser systemUser) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getCountByLoginName",systemUser);
	}

	@Override
	public int initPassword(SystemUser systemUser) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE +"initPassword",systemUser);
	}
}
