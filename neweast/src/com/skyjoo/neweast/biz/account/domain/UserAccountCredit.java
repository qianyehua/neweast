package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

/**
 * 账户信用信息表
 * @author lxh
 * @version 2015-04-17 09:52:02
 */
public class UserAccountCredit extends DomainBase {
	
	private static final long serialVersionUID = 2293101972251454042L;
	//pk,seq
	private Long id;
	//会员ID
	private Long accountId;
	//信用值
	private Long creditScore;
	//信用等级
	private Long creditLevelNo;
	//信用等级名称
	private String creditLevelName;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModify;
	//类型
	private Integer creditType = EnumUserAccountType.BUYER.getValue();

	public UserAccountCredit() {
	}
	
	/**
	 * 买家
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
	
	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置会员ID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**获取会员ID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	/**设置信用值*/
	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}
	/**获取信用值*/
	public Long getCreditScore() {
		return this.creditScore;
	}
	
	/**设置信用等级*/
	public void setCreditLevelNo(Long creditLevelNo) {
		this.creditLevelNo = creditLevelNo;
	}
	/**获取信用等级*/
	public Long getCreditLevelNo() {
		return this.creditLevelNo;
	}
	
	/**设置信用等级名称*/
	public void setCreditLevelName(String creditLevelName) {
		this.creditLevelName = creditLevelName;
	}
	/**获取信用等级名称*/
	public String getCreditLevelName() {
		return this.creditLevelName;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取修改时间*/
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