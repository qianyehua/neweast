package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;

public interface TradeRefundDAO {

	/**
	 * �õ��˿��б� ��ҳ
	 * @param page
	 * @return
	 */
	public void getPaginatedTradeRefund(TradeRefundQuery query);
	
	/**
	 * ���ݶ���id��ȡ�˿�����
	 * @param orderId
	 * @return
	 */
	public List<TradeRefund> selectTradeRefundByOrderId(Long orderId);
	
	/**
	 * ����id��ȡ�˿�����
	 * @param orderId
	 * @return
	 */
	public TradeRefund selectTradeRefundById(Long id);

	/**
	 * �����˿�˿��
	 * @param refund
	 * @return
	 */
	public int updateTradeRefund(TradeRefund refund);
	
}
