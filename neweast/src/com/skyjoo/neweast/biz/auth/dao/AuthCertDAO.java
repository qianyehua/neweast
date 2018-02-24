package com.skyjoo.neweast.biz.auth.dao;

import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface AuthCertDAO {

	/**分页 **/
	Paginable<AuthCertQurty> getPaginatedAuthCertQuery(
			Paginable<AuthCertQurty> qurty);

	/**根据ID 获取详情 */
	AuthCertQurty getAuthCertQueryById(long id);

	/**删除 鉴定数据**/
	int remove(long id);


}
