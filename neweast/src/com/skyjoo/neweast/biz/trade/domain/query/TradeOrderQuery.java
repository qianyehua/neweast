package com.skyjoo.neweast.biz.trade.domain.query;

import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.DateUtil;
import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.trade.domain.TradeOrder;

/**
 * ���׶������ҳ��ѯ����
 * @author lxh
 * @version 2015-04-28 17:45:00
 */
public class TradeOrderQuery extends Pagination<TradeOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420551093446348925L;
	//���״���ʱ�䣨��ʼ������ʱ�䣩
	private String gmtCreateStart = DateUtil.convertDateToString(new Date());
	private String gmtCreateEnd = DateUtil.convertDateToString(new Date());;
	
	//����״̬���ȴ�����ȷ���˷ѣ��ȴ���Ҹ����ȷ�ϻ��ȴ����ҷ������ȴ����ȷ���ջ������׳ɹ���������ɣ����׹رգ�
	private String status;
	
	//��ҵ�¼����
	private String buyerLoginId;
	//���ҵ�¼����
	private String sellerLoginId;
	
	//�������
	private String orderNo;
	//����Ʒ���
	private String artNo;
	
	private List<Long> ids;
	
	public String getGmtCreateStart() {
		return gmtCreateStart;
	}
	public void setGmtCreateStart(String gmtCreateStart) {
		this.gmtCreateStart = gmtCreateStart;
	}
	public String getGmtCreateEnd() {
		return gmtCreateEnd;
	}
	public void setGmtCreateEnd(String gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuyerLoginId() {
		return buyerLoginId;
	}
	public void setBuyerLoginId(String buyerLoginId) {
		this.buyerLoginId = buyerLoginId;
	}
	public String getSellerLoginId() {
		return sellerLoginId;
	}
	public void setSellerLoginId(String sellerLoginId) {
		this.sellerLoginId = sellerLoginId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getArtNo() {
		return artNo;
	}
	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
	public boolean enable() {
		if(StringUtil.isBlank(this.gmtCreateStart)
				&& StringUtil.isBlank(this.gmtCreateEnd)
				&& StringUtil.isBlank(this.status)
				&& StringUtil.isBlank(this.buyerLoginId)
				&& StringUtil.isBlank(this.sellerLoginId)
				&& StringUtil.isBlank(this.orderNo)
				&& StringUtil.isBlank(this.artNo)) {
			return false;
		}
		return true;
	}
}