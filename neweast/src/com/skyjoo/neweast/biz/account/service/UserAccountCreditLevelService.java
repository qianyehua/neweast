/**
 * 
 */
package com.skyjoo.neweast.biz.account.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;

/**
 * @author admin
 *
 */
public interface UserAccountCreditLevelService {

	/**
	 * ��ȡ����������Ч���ʺŵȼ��б�
	 */
	public List<UserAccountCreditLevel> getUACL();
	
	/**
	 * ��ȡ����δ��Ч���ʺŵȼ��б�
	 */
	public List<UserAccountCreditLevel> getNewUACL();
	
	/**
	 * �޸����õȼ�
	 */
	public Long addNewLevel(Map< Integer, UserAccountCreditLevel> map);
	
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
    public boolean isHasValidVersion();

}
