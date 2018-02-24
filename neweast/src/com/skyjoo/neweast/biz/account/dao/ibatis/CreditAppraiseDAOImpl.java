package com.skyjoo.neweast.biz.account.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.account.dao.CreditAppraiseDAO;
import com.skyjoo.neweast.biz.account.domain.CreditAppraise;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@Repository
@SuppressWarnings("deprecation")
public class CreditAppraiseDAOImpl extends BaseDaoiBatis implements CreditAppraiseDAO {

	private static String SQLMAP_SPACE = "CREDIT_APPRAISE.";

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditAppraise> selectCreditAppraiseByUserId(Long userId) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectByUserId", userId);
	}
}