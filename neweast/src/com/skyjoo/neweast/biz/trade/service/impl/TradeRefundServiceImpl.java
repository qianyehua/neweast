package com.skyjoo.neweast.biz.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.trade.dao.TradeRefundDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;
import com.skyjoo.neweast.biz.trade.service.TradeRefundService;
@Service
public class TradeRefundServiceImpl extends BaseManager implements
		TradeRefundService {

	@Autowired
	private TradeRefundDAO tradeRefundDAO;
	
	@Override
	public void getPaginatedRefund(TradeRefundQuery page) {
		tradeRefundDAO.getPaginatedTradeRefund(page);
	}

	@Override
	public TradeRefund getLastTradeRefundByOrderId(Long orderId) {
		List<TradeRefund> refunds = tradeRefundDAO.selectTradeRefundByOrderId(orderId);
		if(refunds.isEmpty()) {
			return null;
		}
		return refunds.get(0);
	}

	@Override
	public TradeRefund getTradeRefundById(Long id) {
		return tradeRefundDAO.selectTradeRefundById(id);
	}

	@Override
	public int editTradeRefund(TradeRefund refund) {
		return tradeRefundDAO.updateTradeRefund(refund);
	}

}
