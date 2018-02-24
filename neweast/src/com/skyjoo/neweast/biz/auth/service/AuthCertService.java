package com.skyjoo.neweast.biz.auth.service;

import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthCertService {

	/**分页*/
	public Paginable<AuthCertQurty> getPaginatedAuthCertQuery(Paginable<AuthCertQurty> qurty);

	/**获取详情 by ID*/
	public AuthCertQurty getAuthCertQueryById(long id);

	/**删除 鉴定表**/
	public int remove(long id);
	
	
}
