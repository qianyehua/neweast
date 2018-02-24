package com.skyjoo.neweast.biz.shop.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;

/**
 * ������֤��ҳ��ѯ
 * @author lxh
 *
 */
public class ShopAuthApplyQuery extends Pagination<ShopAuthApply> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4277806700924897515L;
	
	//��¼ID�����ʵ�ַ
	private String loginId;
	//0����1��ҵ
	private Integer type;
	//��������
	private String gmtApplyStart;
	private String gmtApplyEnd;
	//״̬-2������-1���ʧ��0�����1��˳ɹ�
	private Integer status;
	
	/**���õ�¼ID�����ʵ�ַ*/
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**��ȡ��¼ID�����ʵ�ַ*/
	public String getLoginId() {
		return this.loginId;
	}
	
	/**����0����1��ҵ*/
	public void setType(Integer type) {
		this.type = type;
	}
	public void setType(EnumShopAuthType type) {
		this.type = type.getValue();
	}
	/**��ȡ0����1��ҵ*/
	public Integer getType() {
		return this.type;
	}
	
	/**����״̬-2������-1���ʧ��0�����1��˳ɹ�*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**��ȡ״̬-2������-1���ʧ��0�����1��˳ɹ�*/
	public Integer getStatus() {
		return this.status;
	}
	public String getGmtApplyStart() {
		return gmtApplyStart;
	}
	public void setGmtApplyStart(String gmtApplyStart) {
		this.gmtApplyStart = gmtApplyStart;
	}
	public String getGmtApplyEnd() {
		return gmtApplyEnd;
	}
	public void setGmtApplyEnd(String gmtApplyEnd) {
		this.gmtApplyEnd = gmtApplyEnd;
	}
	
	
}
