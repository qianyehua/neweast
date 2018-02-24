package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeLogDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeLog;
@SuppressWarnings("deprecation")
@Repository
public class TradeLogDaoImpl extends BaseDaoiBatis implements TradeLogDAO {

private static final String SQLMAP_SPACE = "TRADE_LOG.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	@SuppressWarnings("unchecked")
	@Override
	public List<TradeLog> getTradeLogByOrderId(Long orderId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getTradeLogByOrderId", orderId);
	}

}
