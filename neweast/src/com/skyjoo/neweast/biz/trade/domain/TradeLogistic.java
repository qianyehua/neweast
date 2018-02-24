package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.eyeieye.melos.util.Money;
import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticDirection;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticType;

/**
 * 
 * @author fish
 * 
 */
public class TradeLogistic extends DomainBase {

	private static final long serialVersionUID = -7888120662185067618L;

	private Long id;

	private Long orderId;

	private String tradeNo;

	/**
	 * �������� TradeLogisticDirection
	 */
	private String direction;

	/**
	 * ������˿�,��Ӧ���˿�id
	 */
	private Long refundId;

	/**
	 * ���ͷ�ʽ TradeLogisticType
	 */
	private String type;
	/**
	 * �˷�
	 */
	private Money fund;

	/**
	 * ������˾
	 */
	private String company;

	/**
	 * ��������
	 */
	private String logisticNo;

	// -- �ռ������,���������ʱ��Ϊ��
	private String name;
	private String country;
	private String province;
	private String city;
	private String address;
	private String postCode;
	private String mobile;

	/**
	 * ����ʱ��
	 */
	private Date deliverTime;

	/**
	 * �Ƿ��յ����� 0 �� 1 ��
	 */
	private Integer confirmReceive;

	private Date gmtCreate;
	private Date gmtModify;

	public TradeLogistic() {
		super();
	}

	public static void main(String[] args) {
		TradeLogisticType type = TradeLogisticType.deliver;
		System.out.println(type.equals(TradeLogisticType.deliver));
	}

	public void setDirectionEnum(TradeLogisticDirection dir) {
		this.direction = dir.name();
	}

	public TradeLogisticDirection getDirectionEnum() {
		if (this.direction == null) {
			return null;
		}
		return TradeLogisticDirection.valueOf(this.direction);
	}

	public void setTypeEnum(TradeLogisticType tp) {
		this.type = tp.name();
	}

	public TradeLogisticType getTypeEnum() {
		if (this.type == null) {
			return null;
		}
		return TradeLogisticType.valueOf(this.type);
	}
	
	public String getTypeDes() {
		if(TradeLogisticType.deliver.name().equals(this.type)) {
			return "�ͻ�����";
		} else if(TradeLogisticType.self.name().equals(this.type)) {
			return "����";
		}
		return "";
	}

	/**
	 * �Ƿ�ȷ���Ѿ��յ�����
	 * 
	 * @return
	 */
	public boolean isConfirmReceived() {
		return this.confirmReceive != null && this.confirmReceive == 1;
	}

	public void setFundCent(long moneyCent) {
		Money money =new Money();
		money.setCent(moneyCent);
		this.setFund(money);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Money getFund() {
		return fund;
	}

	public void setFund(Money fund) {
		this.fund = fund;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLogisticNo() {
		return logisticNo;
	}

	public void setLogisticNo(String logisticNo) {
		this.logisticNo = logisticNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public Integer getConfirmReceive() {
		return confirmReceive;
	}

	public void setConfirmReceive(Integer confirmReceive) {
		this.confirmReceive = confirmReceive;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

}
