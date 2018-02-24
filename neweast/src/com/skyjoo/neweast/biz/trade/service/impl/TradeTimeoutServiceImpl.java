package com.skyjoo.neweast.biz.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.trade.dao.TradeTimeoutDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeTimeout;
import com.skyjoo.neweast.biz.trade.service.TradeTimeoutService;

@Service
public class TradeTimeoutServiceImpl implements TradeTimeoutService {

	@Autowired
	private TradeTimeoutDAO tradeTimeoutDAO;
	
	@Override
	public List<TradeTimeout> getTradeTimeoutByOrderId(Long orderId) {
		return tradeTimeoutDAO.selectTradeTimeoutByOrderId(orderId);
	}

}
