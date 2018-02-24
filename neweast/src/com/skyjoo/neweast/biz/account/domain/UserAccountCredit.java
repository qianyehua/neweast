package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

/**
 * �˻�������Ϣ��
 * @author lxh
 * @version 2015-04-17 09:52:02
 */
public class UserAccountCredit extends DomainBase {
	
	private static final long serialVersionUID = 2293101972251454042L;
	//pk,seq
	private Long id;
	//��ԱID
	private Long accountId;
	//����ֵ
	private Long creditScore;
	//���õȼ�
	private Long creditLevelNo;
	//���õȼ�����
	private String creditLevelName;
	//����ʱ��
	private Date gmtCreate;
	//�޸�ʱ��
	private Date gmtModify;
	//����
	private Integer creditType = EnumUserAccountType.BUYER.getValue();

	public UserAccountCredit() {
	}
	
	/**
	 * ���
	 * @param accountId
	 * @param creditScore
	 */
	public UserAccountCredit(Long accountId, Long creditScore) {
		this.accountId = accountId;
		this.creditScore = creditScore;
	}
	
	public UserAccountCredit(Long accountId, Integer creditType, Long creditScore) {
		this.accountId = accountId;
		this.creditType = creditType;
		this.creditScore = creditScore;
	}
	
	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**���û�ԱID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**��ȡ��ԱID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	/**��������ֵ*/
	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}
	/**��ȡ����ֵ*/
	public Long getCreditScore() {
		return this.creditScore;
	}
	
	/**�������õȼ�*/
	public void setCreditLevelNo(Long creditLevelNo) {
		this.creditLevelNo = creditLevelNo;
	}
	/**��ȡ���õȼ�*/
	public Long getCreditLevelNo() {
		return this.creditLevelNo;
	}
	
	/**�������õȼ�����*/
	public void setCreditLevelName(String creditLevelName) {
		this.creditLevelName = creditLevelName;
	}
	/**��ȡ���õȼ�����*/
	public String getCreditLevelName() {
		return this.creditLevelName;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**�����޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ�޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}

	public Integer getCreditType() {
		return creditType;
	}

	public void setCreditType(Integer creditType) {
		this.creditType = creditType;
	}
	
}