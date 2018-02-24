package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class ArtLedger {

	/**
	 * seq,pk
	 */
	private Long id;
	/**
	 * 艺术品id
	 */
	private Long artId;
	/**
	 * 是否分账 0:不分账 1：分账
	 */
	private Integer isLedger;
	/**
	 * 收费费承担 0:卖家 1:交易所
	 */
	private Integer commission;
	/**
	 * 分账方式 0:按金额 1：按比例
	 */
	private Integer ledgerMethod;
	/**
	 * 港币分账比例
	 */
	private Float hdkRate;
    /**
     * 人民币分账比例
     */
    private Float rmbRate;	
    /**
     * 人民币分账金额
     */
    private Float rmbMoney;
    
    /**
     * 操作员
     */
    private String operator;
    
    /**
     * 创建时间
     */
    private Date gmtCreator; 
	/**
	 * 最后修改时间
	 */
	private Date gmtModify;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getArtId() {
        return artId;
    }
    public void setArtId(Long artId) {
        this.artId = artId;
    }
    public Integer getIsLedger() {
        return isLedger;
    }
    public void setIsLedger(Integer isLedger) {
        this.isLedger = isLedger;
    }
    public Integer getCommission() {
        return commission;
    }
    public void setCommission(Integer commission) {
        this.commission = commission;
    }
    public Integer getLedgerMethod() {
        return ledgerMethod;
    }
    public void setLedgerMethod(Integer ledgerMethod) {
        this.ledgerMethod = ledgerMethod;
    }

    public Float getHdkRate() {
        return hdkRate;
    }
    public void setHdkRate(Float hdkRate) {
        this.hdkRate = hdkRate;
    }
    public Float getRmbRate() {
        return rmbRate;
    }
    public void setRmbRate(Float rmbRate) {
        this.rmbRate = rmbRate;
    }
    public Float getRmbMoney() {
        return rmbMoney;
    }
    public void setRmbMoney(Float rmbMoney) {
        this.rmbMoney = rmbMoney;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public Date getGmtCreator() {
        return gmtCreator;
    }
    public void setGmtCreator(Date gmtCreator) {
        this.gmtCreator = gmtCreator;
    }
    public Date getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }	
}
