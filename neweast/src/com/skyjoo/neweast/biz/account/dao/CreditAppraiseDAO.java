package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.CreditAppraise;

public interface CreditAppraiseDAO {
	
	/**
	 * ��ȡ�������
	 * @param userId
	 * @return
	 */
	public List<CreditAppraise> selectCreditAppraiseByUserId(Long userId);

}
