package com.skyjoo.neweast.biz.point.domain;

public class ExcelCell {
	private String tradeAccount;//�����˺�
	private Long amount;//������
	private String reason;//ԭ��
	private String badAmount;//����Ļ�������
	private Integer index;//����
	private String badReason;//ʧ��ԭ��
	
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
