package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeRefundDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;
@SuppressWarnings("deprecation")
@Repository
public class TradeRefundDaoImpl extends BaseDaoiBatis implements TradeRefundDAO {

	private static final String SQLMAP_SPACE = "TRADE_REFUND.";

	@Override
	public void getPaginatedTradeRefund(TradeRefundQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TradeRefund> selectTradeRefundByOrderId(Long orderId) {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectByOrderId", orderId);
	}

	@Override
	public TradeRefund selectTradeRefundById(Long id) {
		return (TradeRefund) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectById", id);
	}

	@Override
	public int updateTradeRefund(TradeRefund refund) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", refund);
	}


}
