package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeOrderStatus;

/**
 * ���׶�����
 * @author lxh
 * @version 2015-04-28 17:45:00
 */
public class TradeOrder extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6842607784875064967L;
	//pk,seq
	private Long id;
	//������(YYYYMMDD123456)
	private String tradeNo;
	//����id
	private Long sellerId;
	//���ҵ�¼��
	private String sellerLoginId;
	//���id
	private Long buyerId;
	//��ҵ�¼��
	private String buyerLoginId;
	//�ܼ�,�����˷�,��λ��
	private Long totalFee;
	//��Ʒ�۸��ܺ�,�������˷�,��λ��
	private Long totalGoods;
	//�˷�,��λ��
	private Long logisticFund;
	//�������
	private Double serviceFeeRatio;
	//�����
	private Long serviceFee;
	//��Ʒ��������seller���buyer
	private String goodsHolder;
	//����״̬�ȴ���Ҹ���ȴ�����ȷ���˷Ѵ�ȷ�ϻ��ȴ����ҷ����ȴ����ȷ���ջ����׳ɹ���������ѹر�
	private String tradeStatus;
	//��ǰ��Ч�˿�״̬���˿�ȴ�������Ӧ�ȴ���ҷ����ȴ�������Ӧ�ȴ��ٲóɹ��ѹر����
	private String refundStatus;
	//����ʱ��
	private Date payTime;
	//ȷ���ջ�ʱ��
	private Date confirmGoodsTime;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	//�˿�ID
	private Long refundId;

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**���ö�����(YYYYMMDD123456)*/
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**��ȡ������(YYYYMMDD123456)*/
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	/**��������id*/
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**��ȡ����id*/
	public Long getSellerId() {
		return this.sellerId;
	}
	
	/**�������ҵ�¼��*/
	public void setSellerLoginId(String sellerLoginId) {
		this.sellerLoginId = sellerLoginId;
	}
	/**��ȡ���ҵ�¼��*/
	public String getSellerLoginId() {
		return this.sellerLoginId;
	}
	
	/**�������id*/
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	/**��ȡ���id*/
	public Long getBuyerId() {
		return this.buyerId;
	}
	
	/**������ҵ�¼��*/
	public void setBuyerLoginId(String buyerLoginId) {
		this.buyerLoginId = buyerLoginId;
	}
	/**��ȡ��ҵ�¼��*/
	public String getBuyerLoginId() {
		return this.buyerLoginId;
	}
	
	/**�����ܼ�,�����˷�,��λ��*/
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	/**��ȡ�ܼ�,�����˷�,��λ��*/
	public Long getTotalFee() {
		return this.totalFee;
	}
	
	/**������Ʒ�۸��ܺ�,�������˷�,��λ��*/
	public void setTotalGoods(Long totalGoods) {
		this.totalGoods = totalGoods;
	}
	/**��ȡ��Ʒ�۸��ܺ�,�������˷�,��λ��*/
	public Long getTotalGoods() {
		return this.totalGoods;
	}
	
	/**�����˷�,��λ��*/
	public void setLogisticFund(Long logisticFund) {
		this.logisticFund = logisticFund;
	}
	/**��ȡ�˷�,��λ��*/
	public Long getLogisticFund() {
		return this.logisticFund;
	}
	
	/**���÷������*/
	public void setServiceFeeRatio(Double serviceFeeRatio) {
		this.serviceFeeRatio = serviceFeeRatio;
	}
	/**��ȡ�������*/
	public Double getServiceFeeRatio() {
		return this.serviceFeeRatio;
	}
	
	/**���÷����*/
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**��ȡ�����*/
	public Long getServiceFee() {
		return this.serviceFee;
	}
	
	/**������Ʒ��������seller���buyer*/
	public void setGoodsHolder(String goodsHolder) {
		this.goodsHolder = goodsHolder;
	}
	/**��ȡ��Ʒ��������seller���buyer*/
	public String getGoodsHolder() {
		return this.goodsHolder;
	}
	
	/**���ý���״̬�ȴ���Ҹ���ȴ�����ȷ���˷Ѵ�ȷ�ϻ��ȴ����ҷ����ȴ����ȷ���ջ����׳ɹ���������ѹر�*/
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	/**��ȡ����״̬�ȴ���Ҹ���ȴ�����ȷ���˷Ѵ�ȷ�ϻ��ȴ����ҷ����ȴ����ȷ���ջ����׳ɹ���������ѹر�*/
	public String getTradeStatus() {
		return this.tradeStatus;
	}
	
	/**���õ�ǰ��Ч�˿�״̬���˿�ȴ�������Ӧ�ȴ���ҷ����ȴ�������Ӧ�ȴ��ٲóɹ��ѹر����*/
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	/**��ȡ��ǰ��Ч�˿�״̬���˿�ȴ�������Ӧ�ȴ���ҷ����ȴ�������Ӧ�ȴ��ٲóɹ��ѹر����*/
	public String getRefundStatus() {
		return this.refundStatus;
	}
	
	/**���ø���ʱ��*/
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**��ȡ����ʱ��*/
	public Date getPayTime() {
		return this.payTime;
	}
	
	/**����ȷ���ջ�ʱ��*/
	public void setConfirmGoodsTime(Date confirmGoodsTime) {
		this.confirmGoodsTime = confirmGoodsTime;
	}
	/**��ȡȷ���ջ�ʱ��*/
	public Date getConfirmGoodsTime() {
		return this.confirmGoodsTime;
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
	public Long getRefundId() {
		return refundId;
	}
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	
	public Long canRefundFee() {
		if(TradeOrderStatus.waitBuyerConfirmGoods.name().equals(this.tradeStatus)
				|| TradeOrderStatus.success.name().equals(this.tradeStatus)) {
			return this.totalGoods;
		} else {
			return this.totalFee;
		}
	}
}