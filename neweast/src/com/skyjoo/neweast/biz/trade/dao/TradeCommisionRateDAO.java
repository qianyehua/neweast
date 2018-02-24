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
	 * 获取最新且已生效的帐号等级列表
	 */
	public List<TradeCommisionRate> getTCR();
	
	/**
	 * 获取最新未生效的帐号等级列表
	 */
	public List<TradeCommisionRate> getNewTCR();
	
	/**
	 * 获取最新版本号的佣金比例
	 */
	public List<TradeCommisionRate> getNewestTCR();
	
	/**
	 * 获取版本号
	 */
	public Long getLevelVersionNumber();
	
	/**
	 * 获取下个交易日生效的等级数
	 */
	public int getNextLevelCount();
	
	/**
	 * 新增
	 */
	public Long insertLevel(TradeCommisionRate level);
	

}
