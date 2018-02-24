package com.skyjoo.neweast.biz.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderDAO;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderItemDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;
import com.skyjoo.neweast.biz.trade.service.TradeOrderService;

@Service
public class TradeOrderServiceImpl extends BaseManager implements TradeOrderService {

	@Autowired
	private TradeOrderDAO tradeOrderDAO;
	@Autowired
	private TradeOrderItemDAO tradeOrderItemDAO;
	@Autowired
	private CommDatadicCacheService commDatadicCacheService;
	

	@Override
	public void getPageTradeOrder(TradeOrderQuery query) {
		if(StringUtil.isNotBlank(query.getArtNo())) {
			List<Long> ids = tradeOrderItemDAO.selectOrderIdsByArtNo(query.getArtNo());
			if(ids.isEmpty()) {
				ids.add(0L);
			}
			query.setIds(ids);
		}
		tradeOrderDAO.getPageTradeOrder(query);
	}


	@Override
	public TradeOrder getTradeOrderByOrderId(Long orderId) {
		return tradeOrderDAO.selectTradeOrderByOrderId(orderId);
	}
	
}
