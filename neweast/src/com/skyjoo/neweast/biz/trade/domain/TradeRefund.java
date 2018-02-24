package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;
import com.hundsun.wudadao.common.Money;
import com.skyjoo.neweast.biz.common.util.MoneyUtils;

/**
 * �����˿��
 * @author lxh
 * @version 2015-04-29 13:47:11
 */
public class TradeRefund extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448479992593154253L;
	//pk,seq
	private Long id;
	//����ID
	private Long orderId;
	//������
	private String tradeNo;
	//�˿�״̬�ȴ�������Ӧ�ȴ���ҷ����ȴ��ٲóɹ��ѹر�
	private String status;
	//���id
	private Long buyerId;
	private String buyerStockAccount;
	private String buyerRealName;
	//����id
	private Long sellerId;
	private String sellerStockAccount;
	private String sellerRealName;
	//�����ܼ�,��λ��
	private Long totalFee;
	//�˿���,��λ��
	private Long refundFee;
	private String refundFeeStr;
	//�˿�֤��
	private String evidence;
	//�˿�ԭ��
	private String cause;
	//�˿�˵��
	private String note;
	//�Ƿ��˻�
	private Integer retuenGoods;
	//�ܾ��˿�֤��
	private String rejectEvidence;
	//�ܾ��˿�ԭ��
	private String rejectCause;
	//�ܾ��˿�˵��
	private String rejectNote;
	//�����˻�ʱ��
	private Date applyTime;
	//��Ӧ�˻�ʱ��
	private Date respondTime;
	//�˿����ʱ��
	private Date completeTime;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	
	private String judgeMemo;

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**���ö���ID*/
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**��ȡ����ID*/
	public Long getOrderId() {
		return this.orderId;
	}
	
	/**���ö�����*/
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**��ȡ������*/
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	/**�����˿�״̬�ȴ�������Ӧ�ȴ���ҷ����ȴ��ٲóɹ��ѹر�*/
	public void setStatus(String status) {
		this.status = status;
	}
	/**��ȡ�˿�״̬�ȴ�������Ӧ�ȴ���ҷ����ȴ��ٲóɹ��ѹر�*/
	public String getStatus() {
		return this.status;
	}
	
	/**�������id*/
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	/**��ȡ���id*/
	public Long getBuyerId() {
		return this.buyerId;
	}
	
	/**��������id*/
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**��ȡ����id*/
	public Long getSellerId() {
		return this.sellerId;
	}
	
	/**���ö����ܼ�,��λ��*/
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	/**��ȡ�����ܼ�,��λ��*/
	public Long getTotalFee() {
		return this.totalFee;
	}
	
	/**�����˿���,��λ��*/
	public void setRefundFee(Long refundFee) {
		this.refundFee = refundFee;
		if(this.refundFee == null) {
			this.refundFeeStr = null;
		} else {
			this.refundFeeStr = MoneyUtils.getMoneyDesc(refundFee);
		}
	}
	/**��ȡ�˿���,��λ��*/
	public Long getRefundFee() {
		return this.refundFee;
	}
	public String getRefundFeeStr() {
		return refundFeeStr;
	}
	public void setRefundFeeStr(String refundFeeStr) {
		this.refundFeeStr = refundFeeStr;
		if(StringUtil.isBlank(this.refundFeeStr)) {
			this.refundFee = 0L;
		} else {
			Money money = new Money(refundFeeStr);
			this.refundFee = money.getCent();
		}
	}
	/**�����˿�֤��*/
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	/**��ȡ�˿�֤��*/
	public String getEvidence() {
		return this.evidence;
	}
	
	/**�����˿�ԭ��*/
	public void setCause(String cause) {
		this.cause = cause;
	}
	/**��ȡ�˿�ԭ��*/
	public String getCause() {
		return this.cause;
	}
	
	/**�����˿�˵��*/
	public void setNote(String note) {
		this.note = note;
	}
	/**��ȡ�˿�˵��*/
	public String getNote() {
		return this.note;
	}
	
	/**�����Ƿ��˻�*/
	public void setRetuenGoods(Integer retuenGoods) {
		this.retuenGoods = retuenGoods;
	}
	/**��ȡ�Ƿ��˻�*/
	public Integer getRetuenGoods() {
		return this.retuenGoods;
	}
	
	/**���þܾ��˿�֤��*/
	public void setRejectEvidence(String rejectEvidence) {
		this.rejectEvidence = rejectEvidence;
	}
	/**��ȡ�ܾ��˿�֤��*/
	public String getRejectEvidence() {
		return this.rejectEvidence;
	}
	
	/**���þܾ��˿�ԭ��*/
	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}
	/**��ȡ�ܾ��˿�ԭ��*/
	public String getRejectCause() {
		return this.rejectCause;
	}
	
	/**���þܾ��˿�˵��*/
	public void setRejectNote(String rejectNote) {
		this.rejectNote = rejectNote;
	}
	/**��ȡ�ܾ��˿�˵��*/
	public String getRejectNote() {
		return this.rejectNote;
	}
	
	/**���������˻�ʱ��*/
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**��ȡ�����˻�ʱ��*/
	public Date getApplyTime() {
		return this.applyTime;
	}
	
	/**������Ӧ�˻�ʱ��*/
	public void setRespondTime(Date respondTime) {
		this.respondTime = respondTime;
	}
	/**��ȡ��Ӧ�˻�ʱ��*/
	public Date getRespondTime() {
		return this.respondTime;
	}
	
	/**�����˿����ʱ��*/
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	/**��ȡ�˿����ʱ��*/
	public Date getCompleteTime() {
		return this.completeTime;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**��������޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ����޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	public String getBuyerStockAccount() {
		return buyerStockAccount;
	}
	public void setBuyerStockAccount(String buyerStockAccount) {
		this.buyerStockAccount = buyerStockAccount;
	}
	public String getBuyerRealName() {
		return buyerRealName;
	}
	public void setBuyerRealName(String buyerRealName) {
		this.buyerRealName = buyerRealName;
	}
	public String getSellerStockAccount() {
		return sellerStockAccount;
	}
	public void setSellerStockAccount(String sellerStockAccount) {
		this.sellerStockAccount = sellerStockAccount;
	}
	public String getSellerRealName() {
		return sellerRealName;
	}
	public void setSellerRealName(String sellerRealName) {
		this.sellerRealName = sellerRealName;
	}
	public String getJudgeMemo() {
		return judgeMemo;
	}
	public void setJudgeMemo(String judgeMemo) {
		this.judgeMemo = judgeMemo;
	}
	
}