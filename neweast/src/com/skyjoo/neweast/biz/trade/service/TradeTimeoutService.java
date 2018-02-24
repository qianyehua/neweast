package com.skyjoo.neweast.biz.trade.service;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeTimeout;

public interface TradeTimeoutService {

	public List<TradeTimeout> getTradeTimeoutByOrderId(Long orderId);
}
