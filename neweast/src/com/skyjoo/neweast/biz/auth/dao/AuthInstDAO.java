package com.skyjoo.neweast.biz.auth.dao;

import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthInstDAO {

	/** ���ݻ����� ��ȡ ����*/
	int checkNameUnique(AuthInst systemAuth);

	/** ��ȡ��һ������*/
	long getNextSeq();

	/** ���� ��������**/
	Long addAuthInst(AuthInst systemAuth);
	
	/** ��ѯ����AuthInst�����,���ط�ҳ����ļ���  */
	Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page);
	
	/**����id��ȡ AuthInst**/
	AuthInst getAuthInstById(Long authId);

	/**�޸�  AuthInst**/
	int updateAuthInst(AuthInst authInst);

	/**���� ����**/
	int resetpw(AuthInst authInst);

	/**��ȡ ���������ļ���������**/
	int getChertCount(Long authId);

	/**ɾ��  AuthInst by ID**/
	int deleteAuthInsByID(Long authId);
	
}
