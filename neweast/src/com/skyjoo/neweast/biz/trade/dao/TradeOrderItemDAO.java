package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

public interface TradeOrderItemDAO {
	
	/**
	 * ��ȡ��������Ʒ������Ķ���ID
	 * @param artId
	 * @return
	 */
	public List<Long> selectOrderIdsByArtNo(String artNo);
}
