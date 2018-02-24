package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordDTO;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordRequest;

/**
 * 订单查询
 * @author admin
 *
 */
public interface TradeOrderDAO {
	
	/**
	 * 订单分页
	 * @param query
	 */
	public void getPageTradeOrder(TradeOrderQuery query);
	
	/**
	 * 查询订单信息
	 * @param orderid
	 * @return
	 */
	public TradeOrder selectTradeOrderByOrderId(Long orderId);

	/**
	 * 获取阻碍会员销户的订单数量 i.e. 后续会产生资金操作的订单
	 * @param id
	 * @return
	 */
	public int selectTradeOrderLimitCountForCancel(Long userId);
	
	
	/**
	 * 获取订单交易记录
	 * @param req
	 * @return
	 */	
	public List<TradeOrderRecordDTO> queryTradeOrderRecord(TradeOrderRecordRequest req);
	
}
