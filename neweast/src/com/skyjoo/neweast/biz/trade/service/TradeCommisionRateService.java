/**
 * 
 */
package com.skyjoo.neweast.biz.trade.service;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRate;

/**
 * @author admin
 *
 */
public interface TradeCommisionRateService {

	/**
	 * ��ȡ����������Ч��Ӷ�����
	 */
	public List<TradeCommisionRate> getTCR();
	
	/**
	 * ��ȡ����δ��Ч��Ӷ�����
	 */
	public List<TradeCommisionRate> getNewTCR();
	
	/**
	 * ��ȡ���°汾�ŵ�Ӷ�����
	 */
	public List<TradeCommisionRate> getNewestTCR();
	
	/**
	 * �޸����õȼ�
	 */
	public Long addNewLevel(List<TradeCommisionRate> list);
	
}
