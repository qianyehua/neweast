package com.skyjoo.neweast.biz.trade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.trade.dao.TradeLogisticDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeLogistic;
import com.skyjoo.neweast.biz.trade.service.TradeLogisticService;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticDirection;

@Service("tradeLogisticService")
public class TradeLogisticServiceImpl implements TradeLogisticService{

    @Autowired
    private TradeLogisticDAO tradeLogisticDAO;

	@Override
	public TradeLogistic getTradeLogisticByOrderId(Long orderId) {
		return getTradeLogistic(orderId, null, TradeLogisticDirection.seller2buyer);
	}

	@Override
	public TradeLogistic getTradeLogistic(Long orderId, Long refundId, TradeLogisticDirection direction) {
		return tradeLogisticDAO.selectTradeLogistic(orderId, refundId, direction.name());
	}
    
    
}
