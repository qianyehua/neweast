package com.skyjoo.neweast.biz.point.domain;

public class ExcelCell {
	private String tradeAccount;//交易账号
	private Long amount;//积分数
	private String reason;//原因
	private String badAmount;//错误的积分数据
	private Integer index;//序列
	private String badReason;//失败原因
	
    public String getTradeAccount() {
        return tradeAccount;
    }
    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getBadAmount() {
        return badAmount;
    }
    public void setBadAmount(String badAmount) {
        this.badAmount = badAmount;
    }
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public String getBadReason() {
        return badReason;
    }
    public void setBadReason(String badReason) {
        this.badReason = badReason;
    }

	 
	 
}
