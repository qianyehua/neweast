package com.skyjoo.neweast.biz.auth.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.auth.dao.AuthCertDAO;
import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;


@Repository
@SuppressWarnings("deprecation")
public class AuthCertDAOImpl extends BaseDaoiBatis implements AuthCertDAO {

	private static String SQLMAP_SPACE = "AUTH_CERT.";

	@Override
	public Paginable<AuthCertQurty> getPaginatedAuthCertQuery(
			Paginable<AuthCertQurty> qurty) {
		try
        {
            super.paginate(qurty, SQLMAP_SPACE +"getAuthCertQueryCount",
            			SQLMAP_SPACE +"getPaginatedAuthCertQuery");
            return qurty;
        }catch(Exception e)
        {
           log.error(e.getStackTrace());
        }
        return null;
	}

	@Override
	public AuthCertQurty getAuthCertQueryById(long id) {
		return (AuthCertQurty) this.getSqlMapClientTemplate()
				.queryForObject(SQLMAP_SPACE +"getAuthCertQueryById",id);
	}

	@Override
	public int remove(long id) {
		return (int) this.getSqlMapClientTemplate()
				.delete(SQLMAP_SPACE +"deleteAuthCertByID",id);
	}

}
