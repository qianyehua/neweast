package com.skyjoo.neweast.biz.auth.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.auth.dao.AuthInstDAO;
import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;

@Repository
@SuppressWarnings("deprecation")
public class AuthInstDAOImpl extends BaseDaoiBatis implements AuthInstDAO {

	private static String SQLMAP_SPACE = "Auth_Inst.";

	@Override
	public int checkNameUnique(AuthInst systemAuth) {
		int i = (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getCountByName",systemAuth);
		return i;
	}

	@Override
	public long getNextSeq() {
		return (Long) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getNextSeq");
	}

	@Override
	public Long addAuthInst(AuthInst systemAuth) {
		return (Long)this.getSqlMapClientTemplate().insert(SQLMAP_SPACE +"addAuthInst", systemAuth);
	}

	@Override
	public Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page) {
        try
        {
            super.paginate(page, SQLMAP_SPACE +"getAuthInstCount",
            			SQLMAP_SPACE +"getPaginatedAuthInst");
            return page;
        }catch(Exception e)
        {
           log.error(e.getStackTrace());
        }
        return null;
	}

	@Override
	public AuthInst getAuthInstById(Long authId) {
		return (AuthInst)this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getAuthInstById", authId);
	}

	@Override
	public int updateAuthInst(AuthInst authInst) {
		return (Integer)this.getSqlMapClientTemplate().update(SQLMAP_SPACE +"updateAuthInst", authInst);
	}

	@Override
	public int resetpw(AuthInst authInst) {
		return (Integer)this.getSqlMapClientTemplate().update(SQLMAP_SPACE +"resetpw", authInst);
	}

	@Override
	public int getChertCount(Long authId) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE +"getChertCount", authId);
	}

	@Override
	public int deleteAuthInsByID(Long authId) {
		return (Integer)this.getSqlMapClientTemplate().delete(SQLMAP_SPACE +"deleteAuthInsByID", authId);
	}

}
