package com.skyjoo.neweast.biz.account.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.account.dao.UserAccountCreditDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

@Repository
@SuppressWarnings("deprecation")
public class UserAccountCreditDAOImpl extends BaseDaoiBatis implements UserAccountCreditDAO {

	private static final String SQLMAP_SPACE = "USER_ACCOUNT_CREDIT.";
	
	@Override
	public Long insertUserAccountCredit(UserAccountCredit credit) {
		return (Long) getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", credit);
	}

	@Override
	public UserAccountCredit selectByAccountIdAndType(Long accountId, Integer creditType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountId", accountId);
		map.put("creditType", creditType);
		return (UserAccountCredit) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByAccountIdAndType", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccountCredit> selectByAccountIdsAndType(List<Long> accountIds, EnumUserAccountType creditType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountIds", accountIds);
		map.put("creditType", creditType.getValue());
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectByAccountIdsAndType", map);
	}

	@Override
	public int batchUpdateUserAccountCredit(final List<UserAccountCredit> creditList) {
		return getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {
			@Override
			public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				Integer count = 0;
				for (UserAccountCredit credit : creditList) {
					count = count + executor.update(SQLMAP_SPACE + "updateLevel", credit);
				}
				executor.executeBatch();
				return count;
			}
		});
	}

}
