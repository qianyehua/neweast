package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;

public interface TradeRefundDAO {

	/**
	 * 得到退款列表 分页
	 * @param page
	 * @return
	 */
	public void getPaginatedTradeRefund(TradeRefundQuery query);
	
	/**
	 * 根据订单id获取退款详情
	 * @param orderId
	 * @return
	 */
	public List<TradeRefund> selectTradeRefundByOrderId(Long orderId);
	
	/**
	 * 根据id获取退款详情
	 * @param orderId
	 * @return
	 */
	public TradeRefund selectTradeRefundById(Long id);

	/**
	 * 更新退款（退款金额）
	 * @param refund
	 * @return
	 */
	public int updateTradeRefund(TradeRefund refund);
	
}
