package com.skyjoo.neweast.biz.point.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class UserPoint extends DomainBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -637556547560442601L;
	private Long id;
	/*
	 * 用户账户
	 */
	private String tradeAccount;
	/*
	 * 当前数量
	 */
	private Long currentAmount;
	/*
	 * 冻结数量
	 */
	private Long frozenAmount;
	
	private String name;
	private Date GMTCreate;
	private Date GMTModify;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTradeAccount() {
        return tradeAccount;
    }
    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }
    public Long getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(Long currentAmount) {
        this.currentAmount = currentAmount;
    }
    public Long getFrozenAmount() {
        return frozenAmount;
    }
    public void setFrozenAmount(Long frozenAmount) {
        this.frozenAmount = frozenAmount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getGMTCreate() {
        return GMTCreate;
    }
    public void setGMTCreate(Date gMTCreate) {
        GMTCreate = gMTCreate;
    }
    public Date getGMTModify() {
        return GMTModify;
    }
    public void setGMTModify(Date gMTModify) {
        GMTModify = gMTModify;
    }

	 
}
