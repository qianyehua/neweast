package com.skyjoo.neweast.biz.point.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.hundsun.wudadao.common.Result;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.point.dao.UserPointDao;
import com.skyjoo.neweast.biz.point.domain.UserPoint;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;

@Repository
public class UserPointDaoIbatis extends BaseDaoiBatis implements UserPointDao {

	private static String SQLSPACE = "USER_POINT.";

	@Override
	public Result<Void> add(UserPoint userPoint) {
		this.getSqlMapClientTemplate().insert(SQLSPACE + "insert", userPoint);
		return null;
	}

	@Override
	public Result<Void> update(UserPoint userPoint) {
		this.getSqlMapClientTemplate().update(SQLSPACE + "update", userPoint);
		return null;
	}

	@Override
	public UserPoint getUserPointByTradeAccount(String account) {
		return (UserPoint) this.getSqlMapClientTemplate().queryForObject(
				SQLSPACE + "getUserPointByTradeAccount", account);
	}

	@Override
	public void list(UserPointQuery query) {
		this.paginate(query, SQLSPACE + "count", SQLSPACE + "query");
	}

    @Override
    public int checkAccount(String account) {
         
        return (int) this.getSqlMapClientTemplate().queryForObject(SQLSPACE+"check", account);
    }

	/*@SuppressWarnings("deprecation")
	@Override
	public int insertCell(final List<UserPoint> addList,
			final List<UserPoint> upList) {
		return this.getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Integer>() {

					@Override
					public Integer doInSqlMapClient(SqlMapExecutor executor)
							throws SQLException {
						executor.startBatch();
						for (UserPoint userPoint : upList) {
							executor.update(SQLSPACE + "update", userPoint);
						}
						for (UserPoint userPoint : addList) {
							executor.insert(SQLSPACE + "insert", userPoint);
						}
						return executor.executeBatch();
					}
				});
	}*/

}
