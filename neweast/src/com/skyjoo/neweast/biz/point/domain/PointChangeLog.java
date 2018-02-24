package com.skyjoo.neweast.biz.point.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class PointChangeLog extends DomainBase {

	private static final long serialVersionUID = 8122963234747391927L;

	private Long id;
	/*
	 * 用户账户
	 */
	private String tradeAccount;
	/*
	 * 积分流水类型 login登录 trade交易 comment评论 concern关注 trade_appraise交易评价
	 * certification实名认证 bank_bind绑定银行addition加成 present活动赠送 store_consume商城消费
	 * store_back商城退回 store_present商城赠送
	 */
	private String pointType;
	/*
	 * 发生渠道
	 */
	private String occurChannel;
	/*
	 * 发生时间
	 */
	private Date occurTime;
	/*
	 * 关联ID
	 */
	private String relateId;
	/*
	 * 关联对象
	 */
	private String relateObject;
	/*
	 * 关联数量
	 */
	private Long relateAmount;
	/*
	 * 积分原始数量
	 */
	private Long pointPre;
	/*
	 * 积分数量
	 */
	private Long pointAmount;
	/*
	 * 积分结余数量
	 */
	private Long pointPost;
	/*
	 * 原因
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
