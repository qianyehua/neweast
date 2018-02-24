package com.skyjoo.neweast.biz.trade.interfaces;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.dao.UserAccountDAO;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.trade.dao.TradeOrderDAO;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordDTO;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRecordRequest;
import com.skyjoo.wudadao.neweast.dto.TradeOrderRequest;
import com.skyjoo.wudadao.neweast.interfaces.TradeOrderService;
@Deprecated
@Service("remoteTradeOrderService")
public class RemoteTradeOrderServiceImpl implements TradeOrderService {

    protected final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserAccountDAO userAccountDAO;
    @Autowired
    private TradeOrderDAO  tradeOrderDAO;

    @Override
    public boolean isAllTradeOrderComplete(TradeOrderRequest req) {

        log.debug("isAllTradeOrderComplete start.req=" + req);
        
        UserAccount account = userAccountDAO.selectUserAccountByFundAccount(req.getFundAccount());
        if (account == null)
            return true;

        return tradeOrderDAO.selectTradeOrderLimitCountForCancel(account.getId()) == 0;
    }

    @Override
	public Result<List<TradeOrderRecordDTO>> queryTradeOrderRecord(TradeOrderRecordRequest req) {
		log.debug("queryTradeOrderRecord start.req=" + req);
		Result<List<TradeOrderRecordDTO>> result = new  Result<List<TradeOrderRecordDTO>>();
        //校验必要参数是否为空
        if (req == null ) {
            log.error("queryTradeOrderRecord params error.req=" + req);
            result.setSuccess(false);
            return result;
        } 	
		List<TradeOrderRecordDTO> reslist = tradeOrderDAO.queryTradeOrderRecord(req);
		result.setSuccess(true);
		result.setResult(reslist);
		return result;
	}


}
