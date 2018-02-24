package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class ArtLedger {

	/**
	 * seq,pk
	 */
	private Long id;
	/**
	 * ����Ʒid
	 */
	private Long artId;
	/**
	 * �Ƿ���� 0:������ 1������
	 */
	private Integer isLedger;
	/**
	 * �շѷѳе� 0:���� 1:������
	 */
	private Integer commission;
	/**
	 * ���˷�ʽ 0:����� 1��������
	 */
	private Integer ledgerMethod;
	/**
	 * �۱ҷ��˱���
	 */
	private Float hdkRate;
    /**
     * ����ҷ��˱���
     */
    private Float rmbRate;	
    /**
     * ����ҷ��˽��
     */
    private Float rmbMoney;
    
    /**
     * ����Ա
     */
    private String operator;
    
    /**
     * ����ʱ��
     */
    private Date gmtCreator; 
	/**
	 * ����޸�ʱ��
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
