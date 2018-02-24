package com.skyjoo.neweast.biz.account.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.account.dao.CreditAppraiseDAO;
import com.skyjoo.neweast.biz.account.domain.CreditAppraise;
import com.skyjoo.neweast.biz.account.service.CreditAppraiseService;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;
import com.skyjoo.wudadao.common.enums.mall.trade.EnumAppraiseScore;

@Service
public class CreditAppraiseServiceImpl implements CreditAppraiseService {
	
	@Autowired
	private CreditAppraiseDAO creditAppraiseDAO;

	@Override
	public Map<Integer, Map<Integer, Map<Integer, Integer>>> statisticCreditAppraiseCount(Long userId) {
		Map<Integer, Map<Integer, Map<Integer, Integer>>> statics = new HashMap<Integer, Map<Integer, Map<Integer, Integer>>>();
		statics.put(EnumUserAccountType.BUYER.getValue(), new HashMap<Integer, Map<Integer, Integer>>());
		statics.put(EnumUserAccountType.SELLER.getValue(), new HashMap<Integer, Map<Integer, Integer>>());
		
		for (Map<Integer, Map<Integer, Integer>> userTypeMap : statics.values()) {
	    	for (EnumAppraiseScore score : EnumAppraiseScore.values()) {
	    		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    		for (int i = 1; i < 5; i++) {
	    			map.put(i, 0);
				}
	    		userTypeMap.put(score.getType(), map);
			}
		}
		
    	Calendar oneweek = Calendar.getInstance();
    	oneweek.add(Calendar.WEEK_OF_MONTH, -1);
    	Calendar onemonth = Calendar.getInstance();
    	onemonth.add(Calendar.MONTH, -1);
    	Calendar sixmonth = Calendar.getInstance();
    	sixmonth.add(Calendar.MONTH, -6);

		List<CreditAppraise> appraiseList = creditAppraiseDAO.selectCreditAppraiseByUserId(userId);
    	for (CreditAppraise appraise : appraiseList) {
    		Map<Integer, Integer> levelMap = null;
    		if(appraise.getSellerId().equals(userId)) {
    			levelMap = statics.get(EnumUserAccountType.SELLER.getValue()).get(appraise.getAppraiseLevel());
    		} else {
    			levelMap = statics.get(EnumUserAccountType.BUYER.getValue()).get(appraise.getAppraiseLevel());
    		}
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(appraise.getGmtCreate());
    		if(cal.after(oneweek)) {
    			levelMap.put(1, levelMap.get(1) + 1);
    		} else if(cal.after(onemonth)) {
    			levelMap.put(2, levelMap.get(2) + 1);
    		} else if(cal.after(sixmonth)) {
    			levelMap.put(3, levelMap.get(3) + 1);
    		} else {
    			levelMap.put(4, levelMap.get(4) + 1);
    		}
    		
		}
    	
    	//汇总
    	for (Map<Integer, Map<Integer, Integer>> userTypeMap : statics.values()) {
    		Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        	for (int i = 0; i < 5; i++) {
        		total.put(i, 0);
    		}
        	for (EnumAppraiseScore score : EnumAppraiseScore.values()) {
        		Map<Integer, Integer> levelMap = userTypeMap.get(score.getType());
        		levelMap.put(2, levelMap.get(1) + levelMap.get(2));//最近一个月 = 最近一个月 + 最近一周 
        		levelMap.put(3, levelMap.get(2) + levelMap.get(3));//最近6个月   =  最近6个月 + 最近一个月
        		levelMap.put(0, levelMap.get(3) + levelMap.get(4));//横向汇总 = 最近6个月 + 6个月前
        		
        		for (int i = 0; i < 5; i++) {
            		total.put(i, total.get(i) + levelMap.get(i));
        		}
        	}
        	userTypeMap.put(0, total);
		}
    	
    	return statics;
	}

}
