package com.skyjoo.neweast.biz.trade.service;

import com.skyjoo.neweast.biz.trade.domain.TradeLogistic;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticDirection;

public interface TradeLogisticService {
	
	/**
	 * ��ȡ���������򷽵�����
	 * @param orderId
	 * @return
	 */
	public TradeLogistic getTradeLogisticByOrderId(Long orderId);
	
	public TradeLogistic getTradeLogistic(Long orderId, Long refundId, TradeLogisticDirection direction);
}
