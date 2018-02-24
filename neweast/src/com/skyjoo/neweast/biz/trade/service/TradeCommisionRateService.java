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
	 * 获取最新且已生效的佣金比例
	 */
	public List<TradeCommisionRate> getTCR();
	
	/**
	 * 获取最新未生效的佣金比例
	 */
	public List<TradeCommisionRate> getNewTCR();
	
	/**
	 * 获取最新版本号的佣金比例
	 */
	public List<TradeCommisionRate> getNewestTCR();
	
	/**
	 * 修改信用等级
	 */
	public Long addNewLevel(List<TradeCommisionRate> list);
	
}
