package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordDTO;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordRequest;

/**
 * ������ѯ
 * @author admin
 *
 */
public interface TradeOrderDAO {
	
	/**
	 * ������ҳ
	 * @param query
	 */
	public void getPageTradeOrder(TradeOrderQuery query);
	
	/**
	 * ��ѯ������Ϣ
	 * @param orderid
	 * @return
	 */
	public TradeOrder selectTradeOrderByOrderId(Long orderId);

	/**
	 * ��ȡ�谭��Ա�����Ķ������� i.e. ����������ʽ�����Ķ���
	 * @param id
	 * @return
	 */
	public int selectTradeOrderLimitCountForCancel(Long userId);
	
	
	/**
	 * ��ȡ�������׼�¼
	 * @param req
	 * @return
	 */	
	public List<TradeOrderRecordDTO> queryTradeOrderRecord(TradeOrderRecordRequest req);
	
}
