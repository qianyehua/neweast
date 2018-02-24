package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

public interface TradeOrderItemDAO {
	
	/**
	 * 获取所有艺术品相关联的订单ID
	 * @param artId
	 * @return
	 */
	public List<Long> selectOrderIdsByArtNo(String artNo);
}
