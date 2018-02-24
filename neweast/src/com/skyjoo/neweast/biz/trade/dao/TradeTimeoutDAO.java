package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeTimeout;

public interface TradeTimeoutDAO {

	public List<TradeTimeout> selectTradeTimeoutByOrderId(Long orderId);
}
