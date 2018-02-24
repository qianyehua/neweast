package com.skyjoo.neweast.biz.account.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

public interface UserAccountCreditService {
	
	/**
     * ���ݻ�ԱID��ȡ��Ӧ���͵�������Ϣ
	 * @param userId
	 * @param creditType
	 * @return
	 */
	public UserAccountCredit getByAccountIdAndType(Long userId, EnumUserAccountType creditType);

    /**
     * ȫ�ָ��»�Աָ�����͵ĵȼ�
     * @param creditType
     * @return
     */
    public Result<Integer> updateCreditLevelAll(EnumUserAccountType creditType);
    
    /**
     * �ֲ����»�Աָ�����͵ĵȼ�
     * @param creditType
     * @return
     */
    public Result<Integer> updateCreditLevelPart(EnumUserAccountType creditType);
}
