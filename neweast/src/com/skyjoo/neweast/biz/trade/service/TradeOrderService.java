package com.skyjoo.neweast.biz.trade.service;

import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;

public interface TradeOrderService {

	/**
	 * ������ҳ
	 * @param query
	 */
	public void getPageTradeOrder(TradeOrderQuery query);
	
	/**
	 * ��ѯ������Ϣ
	 * @param orderid
	 * @return
	 */
	public TradeOrder getTradeOrderByOrderId(Long orderId);
}
