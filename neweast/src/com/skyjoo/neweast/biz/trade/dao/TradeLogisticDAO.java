package com.skyjoo.neweast.biz.trade.dao;

import com.skyjoo.neweast.biz.trade.domain.TradeLogistic;

/**
 * 
 * @author fish
 * 
 */
public interface TradeLogisticDAO {
	
	public TradeLogistic selectTradeLogistic(Long orderId, Long refundId, String direction);

}
