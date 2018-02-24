package com.skyjoo.neweast.biz.auth.dao;

import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthCertDAO {

	/**��ҳ **/
	Paginable<AuthCertQurty> getPaginatedAuthCertQuery(
			Paginable<AuthCertQurty> qurty);

	/**����ID ��ȡ���� */
	AuthCertQurty getAuthCertQueryById(long id);

	/**ɾ�� ��������**/
	int remove(long id);


}
