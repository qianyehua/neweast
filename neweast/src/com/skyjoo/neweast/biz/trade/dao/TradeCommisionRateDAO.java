/**
 * 
 */
package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRate;

/**
 * @author admin
 *
 */
public interface TradeCommisionRateDAO {
	
	/**
	 * ��ȡ����������Ч���ʺŵȼ��б�
	 */
	public List<TradeCommisionRate> getTCR();
	
	/**
	 * ��ȡ����δ��Ч���ʺŵȼ��б�
	 */
	public List<TradeCommisionRate> getNewTCR();
	
	/**
	 * ��ȡ���°汾�ŵ�Ӷ�����
	 */
	public List<TradeCommisionRate> getNewestTCR();
	
	/**
	 * ��ȡ�汾��
	 */
	public Long getLevelVersionNumber();
	
	/**
	 * ��ȡ�¸���������Ч�ĵȼ���
	 */
	public int getNextLevelCount();
	
	/**
	 * ����
	 */
	public Long insertLevel(TradeCommisionRate level);
	

}
