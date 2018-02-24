package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeLog;

public interface TradeLogDAO {
	public List<TradeLog> getTradeLogByOrderId(Long orderId);
}
