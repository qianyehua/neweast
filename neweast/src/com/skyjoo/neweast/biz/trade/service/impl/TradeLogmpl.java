package com.skyjoo.neweast.biz.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.trade.dao.TradeLogDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeLog;
import com.skyjoo.neweast.biz.trade.service.TradeLogService;
@Service
public class TradeLogmpl extends BaseManager implements TradeLogService {

	@Autowired
	private TradeLogDAO tradeLogDAO;
	@Override
	public List<TradeLog> getTradeLogByOrderId(Long orderId) {
		List<TradeLog> list = tradeLogDAO.getTradeLogByOrderId(orderId);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}
