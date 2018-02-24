package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccountCredit;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

public interface UserAccountCreditDAO {
	
	/**
	 * ����
	 * @param credit
	 * @return
	 */
	public Long insertUserAccountCredit(UserAccountCredit credit);
	
	/**
	 * ���ݻ�ԱID��ȡ��Ӧ���͵�������Ϣ
	 * @param accountId
	 * @param type
	 * @return
	 */
    public UserAccountCredit selectByAccountIdAndType(Long accountId, Integer creditType);

    /**
     * ���ݻ�ԱIDs��ȡ��Ӧ���͵�������Ϣ
     * @param accountId
     * @param creditType
     * @return
     */
    public List<UserAccountCredit> selectByAccountIdsAndType(List<Long> accountIds, EnumUserAccountType creditType);

    /**
     * �������»�Ա���õȼ�
     */
    public int batchUpdateUserAccountCredit(List<UserAccountCredit> creditList);
}
