/**
 * 
 */
package com.skyjoo.neweast.biz.account.dao;

import java.util.List;

import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;

/**
 * @author admin
 *
 */
public interface UserAccountCreditLevelDAO {
	
	/**
	 * ��ȡ����������Ч���ʺŵȼ��б�
	 */
	public List<UserAccountCreditLevel> getUACL();
	
	/**
	 * ��ȡ����δ��Ч���ʺŵȼ��б�
	 */
	public List<UserAccountCreditLevel> getNewUACL();
	
	/**
	 * ��ȡ�汾��
	 */
	public Long getLevelVersionNumber();
	
	/**
	 * ��ȡ�¸���������Ч�ĵȼ���
	 */
	public int getNextLevelCount();
	
	/**
	 * ����
	 */
	public Long insertLevel(UserAccountCreditLevel level);
	
	/**
	 * ��ȡ���µİ汾���õȼ�
	 */
	public List<UserAccountCreditLevel> getNewestUACL();
	
	/**
	 * ��ȡ����δ��Ч�����õȼ�
	 */
	public List<UserAccountCreditLevel> getInvalidUACL();
	
	/**
	 * ��ȡ�汾��
	 */
	public Long getValidVersion();
	
	/**
	 * ���°汾��
	 */
	public int update(UserAccountCreditLevel level);

    /**
     *�ж��Ƿ�������Ч���õȼ�
     */
    public int isHasValidVersion();

}
