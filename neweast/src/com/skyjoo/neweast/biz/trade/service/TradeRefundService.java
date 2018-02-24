package com.skyjoo.neweast.biz.trade.service;

import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;

public interface TradeRefundService {
	/**
	 * �õ����������ļ�¼ ��ҳ
	 * @param page
	 * @return
	 */
	public void getPaginatedRefund(TradeRefundQuery page);
	
	/**
	 * ���ݶ���id��ȡ���µ��˿�����
	 * @param orderId
	 * @return
	 */
	public TradeRefund getLastTradeRefundByOrderId(Long orderId);
	
	/**
	 * ����id��ȡ�˿�����
	 * @param orderId
	 * @return
	 */
	public TradeRefund getTradeRefundById(Long id);

	/**
	 * �����˿�
	 * @param re_refund
	 * @return
	 */
	public int editTradeRefund(TradeRefund refund);

}
