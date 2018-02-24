package com.skyjoo.neweast.biz.auth.service;

import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthInstService {

	/**检查 空 */
	boolean checkBlank(String str);
	/**检查 鉴定机构 重名*/
	boolean checkNameUnique(AuthInst systemAuth);
	/** 检查 电话 正确*/
	boolean checkcheckTelTrue(AuthInst systemAuth);
	
	/** 增加 鉴定机构*/
	Long addAuthInst(AuthInst systemAuth);
	/** 查询所有AuthInst结果集,返回分页对象的集合  */
	Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page);
	/**根据authgId获取 AuthInst**/
	AuthInst getAuthInstById(Long authId);
	/**修改 AuthInst**/
	int editAuthInst(AuthInst authInst);
	/**重置 密码**/
	int resetpw(AuthInst authInst);
	/**删除鉴定机构**/
	int remove(Long authId);
}
