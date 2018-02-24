/**
 * 
 */
package com.skyjoo.neweast.biz.account.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.account.dao.UserAccountCreditLevelDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

/**
 * @author admin
 *
 */
@Repository
@SuppressWarnings({ "unchecked", "deprecation" })
public class UserAccountCreditLevelDAOImpl extends BaseDaoiBatis implements UserAccountCreditLevelDAO {

	private static String SQLMAP_SPACE = "USER_ACCOUNT_CREDIT_LEVEL.";
	
	@Override
	public List<UserAccountCreditLevel> getUACL() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getUACL");
	}
	
	@Override
		public List<UserAccountCreditLevel> getNewUACL() {
			return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getNewUACL");
		}

	@Override
	public Long getLevelVersionNumber() {
		int i = (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getVersion");
		return Long.parseLong(String.valueOf(i));
	}

	@Override
	public Long insertLevel(UserAccountCreditLevel level) {
		return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE+"insert", level);
	}

	@Override
	public int getNextLevelCount() {
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getNewLevelCount");
	}

	@Override
	public List<UserAccountCreditLevel> getNewestUACL() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getNewestUACL");
	}

	@Override
	public List<UserAccountCreditLevel> getInvalidUACL() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getInvalidUACL");
	}

	@Override
	public Long getValidVersion() {
		int i = (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getValidVersion");
		return Long.parseLong(String.valueOf(i));
	}

	@Override
	public int update(UserAccountCreditLevel level) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE+"update", level);
	}

    @Override
    public int isHasValidVersion() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"isHasValidVersion");
    }
	
}
