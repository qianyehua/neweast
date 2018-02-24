package com.skyjoo.neweast.biz.point.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.hundsun.wudadao.common.Result;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.point.dao.PointChangeLogDao;
import com.skyjoo.neweast.biz.point.domain.PointChangeLog;
import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;

@Repository
public class PointChangeLogDaoIbatis extends BaseDaoiBatis implements
		PointChangeLogDao {
	private static String SQLSPACE = "POINT_CHANGE_LOG.";

	/*@Override
	public Result<Void> add(PointChangeLog changeLog) {
		this.getSqlMapClientTemplate().insert(SQLSPACE + "insert", changeLog);
		return null;
	}
*/
	@Override
	public void list(PointChangeLogQuery pclq) {
		this.paginate(pclq, SQLSPACE + "count", SQLSPACE + "list");
	}

	/*@SuppressWarnings("deprecation")
	@Override
	public Integer insertLogByExcel(final List<PointChangeLog> logs) {
		return this.getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Integer>() {

					@Override
					public Integer doInSqlMapClient(SqlMapExecutor executor)
							throws SQLException {
						executor.startBatch();
						for (PointChangeLog pointChangeLog : logs) {
							executor.insert(SQLSPACE + "insert", pointChangeLog);
						}
						return executor.executeBatch();
					}
				});
	}*/

}
