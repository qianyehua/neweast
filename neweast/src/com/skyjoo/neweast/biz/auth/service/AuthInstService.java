package com.skyjoo.neweast.biz.auth.service;

import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthInstService {

	/**��� �� */
	boolean checkBlank(String str);
	/**��� �������� ����*/
	boolean checkNameUnique(AuthInst systemAuth);
	/** ��� �绰 ��ȷ*/
	boolean checkcheckTelTrue(AuthInst systemAuth);
	
	/** ���� ��������*/
	Long addAuthInst(AuthInst systemAuth);
	/** ��ѯ����AuthInst�����,���ط�ҳ����ļ���  */
	Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page);
	/**����authgId��ȡ AuthInst**/
	AuthInst getAuthInstById(Long authId);
	/**�޸� AuthInst**/
	int editAuthInst(AuthInst authInst);
	/**���� ����**/
	int resetpw(AuthInst authInst);
	/**ɾ����������**/
	int remove(Long authId);
}
