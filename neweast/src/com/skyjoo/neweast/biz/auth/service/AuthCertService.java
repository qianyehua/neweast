package com.skyjoo.neweast.biz.auth.service;

import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthCertService {

	/**��ҳ*/
	public Paginable<AuthCertQurty> getPaginatedAuthCertQuery(Paginable<AuthCertQurty> qurty);

	/**��ȡ���� by ID*/
	public AuthCertQurty getAuthCertQueryById(long id);

	/**ɾ�� ������**/
	public int remove(long id);
	
	
}
