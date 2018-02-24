package com.skyjoo.neweast.biz.trade.service;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeLog;

public interface TradeLogService {

	public List<TradeLog> getTradeLogByOrderId(Long orderId);
}
