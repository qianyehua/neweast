/**
 * 
 */
package com.skyjoo.neweast.biz.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyjoo.neweast.biz.trade.dao.TradeCommisionRateDAO;
import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRate;
import com.skyjoo.neweast.biz.trade.service.TradeCommisionRateService;

/**
 * @author admin
 *
 */
@Service
public class TradeCommisionRateServiceImpl implements
TradeCommisionRateService {

	@Autowired
	private TradeCommisionRateDAO commisionRateDAO;
	
	@Override
	public List<TradeCommisionRate> getTCR() {
		return commisionRateDAO.getTCR();
	}

	@Override
	public List<TradeCommisionRate> getNewTCR() {
		return commisionRateDAO.getNewTCR();
	}
	
	@Override
	@Transactional
	public Long addNewLevel(List<TradeCommisionRate> list) {
		Long version;
		if(commisionRateDAO.getNextLevelCount()==0){
			version=0l;
		}else{
			version = commisionRateDAO.getLevelVersionNumber()+1l;
		}
		Long count=0L;
		for(TradeCommisionRate level : list){
			level.setVersion(version);
			commisionRateDAO.insertLevel(level);
			count++;
		}
		return count;
	}

	@Override
	public List<TradeCommisionRate> getNewestTCR() {
		return commisionRateDAO.getNewestTCR();
	}

}
