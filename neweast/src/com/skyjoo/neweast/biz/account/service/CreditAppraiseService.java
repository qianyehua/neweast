package com.skyjoo.neweast.biz.account.service;

import java.util.Map;

public interface CreditAppraiseService {
    
    /**
     * 统计评价数
	 * @param userId
	 * @return  买/卖家   评价等级  时间 数量
	 */
    public Map<Integer, Map<Integer, Map<Integer, Integer>>> statisticCreditAppraiseCount(Long userId);
}
