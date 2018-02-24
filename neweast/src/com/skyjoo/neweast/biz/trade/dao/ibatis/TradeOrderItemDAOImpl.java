package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderItemDAO;

@Repository
public class TradeOrderItemDAOImpl extends BaseDaoiBatis implements
		TradeOrderItemDAO {

	private static String SQLMAP_SPACE = "TRADE_ORDER_ITEM.";
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Long> selectOrderIdsByArtNo(String artNo) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectOrderIdsByArtNo", artNo);
	}

}
