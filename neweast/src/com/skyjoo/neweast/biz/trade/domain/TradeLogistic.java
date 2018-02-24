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
	 * 物流方向 TradeLogisticDirection
	 */
	private String direction;

	/**
	 * 如果是退款,对应的退款id
	 */
	private Long refundId;

	/**
	 * 运送方式 TradeLogisticType
	 */
	private String type;
	/**
	 * 运费
	 */
	private Money fund;

	/**
	 * 物流公司
	 */
	private String company;

	/**
	 * 物流单号
	 */
	private String logisticNo;

	// -- 收件人相关,当非自提的时候不为空
	private String name;
	private String country;
	private String province;
	private String city;
	private String address;
	private String postCode;
	private String mobile;

	/**
	 * 发货时间
	 */
	private Date deliverTime;

	/**
	 * 是否收到货物 0 否 1 是
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
			return "送货上门";
		} else if(TradeLogisticType.self.name().equals(this.type)) {
			return "自提";
		}
		return "";
	}

	/**
	 * 是否确认已经收到货物
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
