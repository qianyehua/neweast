package com.skyjoo.neweast.biz.account.domain.query;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;

/**
 * ��Ա��ҳ��ѯ
 * @author lxh
 *
 */
public class UserAccountQuery extends Pagination<UserAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7935537553804563714L;
	//���ʵ�ַ
	private String email;
	//�ֻ�����
	private String mobile;
	//����
	private String country;
	//״̬0:���ֻ���֤1:�����õ�¼��Ϣ2:������3:����
	private Integer status;
	//����ʱ��
	private String gmtOpenStart;
	//����ʱ��
	private String gmtOpenEnd;
	//��ʵ����
	private String realName;
	//�ֲ��˺�
	private String stockAccount;
	
	/**���õ��ʵ�ַ*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**��ȡ���ʵ�ַ*/
	public String getEmail() {
		return this.email;
	}
	
	/**�����ֻ�����*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**��ȡ�ֻ�����*/
	public String getMobile() {
		return this.mobile;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**����״̬0:���ֻ���֤1:�����õ�¼��Ϣ2:������3:����*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumUserAccountStatus status) {
		this.status = status.getValue();
	}
	/**��ȡ״̬0:���ֻ���֤1:�����õ�¼��Ϣ2:������3:����*/
	public Integer getStatus() {
		return this.status;
	}
	
	public String getGmtOpenStart() {
		return gmtOpenStart;
	}
	public void setGmtOpenStart(String gmtOpenStart) {
		this.gmtOpenStart = gmtOpenStart;
	}
	public String getGmtOpenEnd() {
		return gmtOpenEnd;
	}
	public void setGmtOpenEnd(String gmtOpenEnd) {
		this.gmtOpenEnd = gmtOpenEnd;
	}
	
	/**������ʵ����*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**��ȡ��ʵ����*/
	public String getRealName() {
		return this.realName;
	}
	
	/**���óֲ��˺�*/
	public void setStockAccount(String stockAccount) {
		this.stockAccount = stockAccount;
	}
	/**��ȡ�ֲ��˺�*/
	public String getStockAccount() {
		return this.stockAccount;
	}
	
}
