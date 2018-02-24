package com.skyjoo.neweast.biz.account.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

public interface UserAccountCreditService {
	
	/**
     * 根据会员ID获取相应类型的信用信息
	 * @param userId
	 * @param creditType
	 * @return
	 */
	public UserAccountCredit getByAccountIdAndType(Long userId, EnumUserAccountType creditType);

    /**
     * 全局更新会员指定类型的等级
     * @param creditType
     * @return
     */
    public Result<Integer> updateCreditLevelAll(EnumUserAccountType creditType);
    
    /**
     * 局部更新会员指定类型的等级
     * @param creditType
     * @return
     */
    public Result<Integer> updateCreditLevelPart(EnumUserAccountType creditType);
}
