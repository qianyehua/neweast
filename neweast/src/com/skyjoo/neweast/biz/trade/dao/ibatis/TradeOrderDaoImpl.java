package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordDTO;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordRequest;

@SuppressWarnings("deprecation")
@Repository
public class TradeOrderDaoImpl extends BaseDaoiBatis implements TradeOrderDAO {

	private static final String SQLMAP_SPACE = "TRADE_ORDER.";
	
	@Override
	public void getPageTradeOrder(TradeOrderQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}
	
	@Override
	public TradeOrder selectTradeOrderByOrderId(Long orderId) {
		return (TradeOrder) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByOrderId", orderId);
	}

	@Override
	public int selectTradeOrderLimitCountForCancel(Long userId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectLimitCountForCancel", userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TradeOrderRecordDTO> queryTradeOrderRecord(
			TradeOrderRecordRequest req) {
        int totalCount = (Integer) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "tradeOrderRecordPageCount", req);
        
        List<TradeOrderRecordDTO> list = null;
        if (totalCount > 0) {
            if (req.getBeginIndex()<= totalCount) {
                list = getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "queryTradeOrderRecord", req);
            }

            if (!list.isEmpty()) {
                list.get(0).setTotalCount(totalCount);
            }
        }		
		return list;
	}

}
