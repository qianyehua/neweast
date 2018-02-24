package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeTimeoutDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeTimeout;

@Repository
@SuppressWarnings("deprecation")
public class TradeTimeoutDAOImpl extends BaseDaoiBatis implements
		TradeTimeoutDAO {

	private static String SQLMAP_SPACE = "TRADE_TIMEOUT.";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TradeTimeout> selectTradeTimeoutByOrderId(Long orderId) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectByOrderId", orderId);
	}

}
