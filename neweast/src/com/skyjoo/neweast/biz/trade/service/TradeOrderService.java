package com.skyjoo.neweast.biz.trade.service;

import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;

public interface TradeOrderService {

	/**
	 * 订单分页
	 * @param query
	 */
	public void getPageTradeOrder(TradeOrderQuery query);
	
	/**
	 * 查询订单信息
	 * @param orderid
	 * @return
	 */
	public TradeOrder getTradeOrderByOrderId(Long orderId);
}
