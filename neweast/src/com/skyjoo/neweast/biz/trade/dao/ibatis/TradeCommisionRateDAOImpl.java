/**
 * 
 */
package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeCommisionRateDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRate;

/**
 * @author admin
 *
 */
@Repository
@SuppressWarnings({ "unchecked", "deprecation" })
public class TradeCommisionRateDAOImpl extends BaseDaoiBatis implements TradeCommisionRateDAO {

	private static String SQLMAP_SPACE = "TRADE_COMMISION_RATE.";
	
	@Override
	public List<TradeCommisionRate> getTCR() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getTCR");
	}
	
	@Override
		public List<TradeCommisionRate> getNewTCR() {
			return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getNewTCR");
		}

	@Override
	public List<TradeCommisionRate> getNewestTCR() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getNewestTCR");
	}
	
	@Override
	public Long getLevelVersionNumber() {
		int i = (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getVersion");
		return Long.parseLong(String.valueOf(i));
	}

	@Override
	public Long insertLevel(TradeCommisionRate level) {
		return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE+"insert", level);
	}

	@Override
	public int getNextLevelCount() {
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getNewTCRCount");
	}

}
