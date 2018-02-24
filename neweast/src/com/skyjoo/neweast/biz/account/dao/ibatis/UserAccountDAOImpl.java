package com.skyjoo.neweast.biz.account.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.account.dao.UserAccountDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@Repository
@SuppressWarnings("deprecation")
public class UserAccountDAOImpl extends BaseDaoiBatis implements
		UserAccountDAO {

	private static String SQLMAP_SPACE = "USER_ACCOUNT.";

	@Override
	public Long insertUserAccount(UserAccount account) {
		return (Long) getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", account);
	}

	@Override
	public void selectUserAccountPage(UserAccountQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}
	
	@Override
	public UserAccount selectUserAccountById(Long id) {
		return (UserAccount) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectById", id);
	}
	
	@Override
	public UserAccount selectUserAccountByStockAccount(String stockAccount) {
		return (UserAccount) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByStockAccount", stockAccount);
	}
	
	@Override
	public UserAccount selectUserAccountByFundAccount(String fundAccount) {
		return (UserAccount) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByFundAccount", fundAccount);
	}
	
	@Override
	public int updateUserAccount(UserAccount account) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", account);
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<Long> getAllSellerId() {
        return (List<Long>)this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getAllSellerId");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Long> getChangeSellerId() {
        return (List<Long>)this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getChangeSellerId");
    }
    
}
