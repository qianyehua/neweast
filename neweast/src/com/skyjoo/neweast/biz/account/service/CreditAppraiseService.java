package com.skyjoo.neweast.biz.account.service;

import java.util.Map;

public interface CreditAppraiseService {
    
    /**
     * ͳ��������
	 * @param userId
	 * @return  ��/����   ���۵ȼ�  ʱ�� ����
	 */
    public Map<Integer, Map<Integer, Map<Integer, Integer>>> statisticCreditAppraiseCount(Long userId);
}
