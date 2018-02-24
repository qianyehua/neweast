package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeLogisticDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeLogistic;

/**
 * 
 * @author fish
 * 
 */
@Repository("tradeLogisticDAO")
@SuppressWarnings("deprecation")
public class TradeLogisticDAOImpl extends BaseDaoiBatis implements
		TradeLogisticDAO {

	private static final String NameSpace = "tradeLogistic.";
	
	@Override
	public TradeLogistic selectTradeLogistic(Long orderId, Long refundId, String direction) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("refundId", refundId);
		map.put("direction", direction);
		return (TradeLogistic) getSqlMapClientTemplate().queryForObject(NameSpace + "select", map);
	}


}
