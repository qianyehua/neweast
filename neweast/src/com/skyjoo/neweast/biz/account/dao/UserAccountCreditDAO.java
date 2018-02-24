package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

public interface UserAccountCreditDAO {
	
	/**
	 * 插入
	 * @param credit
	 * @return
	 */
	public Long insertUserAccountCredit(UserAccountCredit credit);
	
	/**
	 * 根据会员ID获取相应类型的信用信息
	 * @param accountId
	 * @param type
	 * @return
	 */
    public UserAccountCredit selectByAccountIdAndType(Long accountId, Integer creditType);

    /**
     * 根据会员IDs获取相应类型的信用信息
     * @param accountId
     * @param creditType
     * @return
     */
    public List<UserAccountCredit> selectByAccountIdsAndType(List<Long> accountIds, EnumUserAccountType creditType);

    /**
     * 批量更新会员信用等级
     */
    public int batchUpdateUserAccountCredit(List<UserAccountCredit> creditList);
}
