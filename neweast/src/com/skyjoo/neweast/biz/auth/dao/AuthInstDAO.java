package com.skyjoo.neweast.biz.auth.dao;

import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthInstDAO {

	/** 根据机构名 获取 数量*/
	int checkNameUnique(AuthInst systemAuth);

	/** 获取下一个索引*/
	long getNextSeq();

	/** 新增 鉴定机构**/
	Long addAuthInst(AuthInst systemAuth);
	
	/** 查询所有AuthInst结果集,返回分页对象的集合  */
	Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page);
	
	/**根据id获取 AuthInst**/
	AuthInst getAuthInstById(Long authId);

	/**修改  AuthInst**/
	int updateAuthInst(AuthInst authInst);

	/**重置 密码**/
	int resetpw(AuthInst authInst);

	/**获取 鉴定机构的鉴定表数量**/
	int getChertCount(Long authId);

	/**删除  AuthInst by ID**/
	int deleteAuthInsByID(Long authId);
	
}
