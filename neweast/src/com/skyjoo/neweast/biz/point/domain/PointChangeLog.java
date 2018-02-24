package com.skyjoo.neweast.biz.point.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class PointChangeLog extends DomainBase {

	private static final long serialVersionUID = 8122963234747391927L;

	private Long id;
	/*
	 * �û��˻�
	 */
	private String tradeAccount;
	/*
	 * ������ˮ���� login��¼ trade���� comment���� concern��ע trade_appraise��������
	 * certificationʵ����֤ bank_bind������addition�ӳ� present����� store_consume�̳�����
	 * store_back�̳��˻� store_present�̳�����
	 */
	private String pointType;
	/*
	 * ��������
	 */
	private String occurChannel;
	/*
	 * ����ʱ��
	 */
	private Date occurTime;
	/*
	 * ����ID
	 */
	private String relateId;
	/*
	 * ��������
	 */
	private String relateObject;
	/*
	 * ��������
	 */
	private Long relateAmount;
	/*
	 * ����ԭʼ����
	 */
	private Long pointPre;
	/*
	 * ��������
	 */
	private Long pointAmount;
	/*
	 * ���ֽ�������
	 */
	private Long pointPost;
	/*
	 * ԭ��
	 */
	private String reason;
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
    public String getPointType() {
        return pointType;
    }
    public void setPointType(String pointType) {
        this.pointType = pointType;
    }
    public String getOccurChannel() {
        return occurChannel;
    }
    public void setOccurChannel(String occurChannel) {
        this.occurChannel = occurChannel;
    }
    public Date getOccurTime() {
        return occurTime;
    }
    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }
    public String getRelateId() {
        return relateId;
    }
    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }
    public String getRelateObject() {
        return relateObject;
    }
    public void setRelateObject(String relateObject) {
        this.relateObject = relateObject;
    }
    public Long getRelateAmount() {
        return relateAmount;
    }
    public void setRelateAmount(Long relateAmount) {
        this.relateAmount = relateAmount;
    }
    public Long getPointPre() {
        return pointPre;
    }
    public void setPointPre(Long pointPre) {
        this.pointPre = pointPre;
    }
    public Long getPointAmount() {
        if (this.pointAmount!=null) {
            return Math.abs(this.pointAmount);
        }
        return pointAmount;
    }
    public void setPointAmount(Long pointAmount) {
        this.pointAmount = pointAmount;
    }
    public Long getPointPost() {
        return pointPost;
    }
    public void setPointPost(Long pointPost) {
        this.pointPost = pointPost;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
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
