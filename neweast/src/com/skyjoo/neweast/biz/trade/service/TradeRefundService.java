package com.skyjoo.neweast.biz.trade.service;

import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;

public interface TradeRefundService {
	/**
	 * 得到符合条件的记录 分页
	 * @param page
	 * @return
	 */
	public void getPaginatedRefund(TradeRefundQuery page);
	
	/**
	 * 根据订单id获取最新的退款详情
	 * @param orderId
	 * @return
	 */
	public TradeRefund getLastTradeRefundByOrderId(Long orderId);
	
	/**
	 * 根据id获取退款详情
	 * @param orderId
	 * @return
	 */
	public TradeRefund getTradeRefundById(Long id);

	/**
	 * 更新退款
	 * @param re_refund
	 * @return
	 */
	public int editTradeRefund(TradeRefund refund);

}
