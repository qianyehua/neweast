package com.skyjoo.neweast.biz.auth.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * ����������
 * @author LZW
 * @version 2015-04-09 09:37:11
 */
public class AuthInst extends Pagination<AuthInst> {

	private static final long serialVersionUID = 1683664086486342460L;
	
	/**pk,seq*/
	private Long id;
	/**��¼�˺�*/
	private String account;
	/**����*/
	private String password;
	/**��������*/
	private String name;
	/**��ϵ��ַ*/
	private String address;
	/**��ϵ�绰*/
	private String tel;
	/**¼������*/
	private Date gmtEntry;
	/**������*/
	private String operator;
	/**����ʱ��*/
	private Date gmtCreate;
	/**����޸�ʱ��*/
	private Date gmtModify;
	/**��ѯ  ��ʼʱ�� **/
	private String startDate;
	/**��ѯ  ����ʱ��**/
	private String endDate;
	
	
	/**pk,seq*/
	public Long getId() {
		return id;
	}
	/**pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��¼�˺�*/
	public String getAccount() {
		return account;
	}
	/**��¼�˺�*/
	public void setAccount(String account) {
		this.account = account;
	}
	/**����*/
	public String getPassword() {
		return password;
	}
	/**����*/
	public void setPassword(String password) {
		this.password = password;
	}
	/**��������*/
	public String getName() {
		return name;
	}
	/**��������*/
	public void setName(String name) {
		this.name = name;
	}
	/**��ϵ��ַ*/
	public String getAddress() {
		return address;
	}
	/**��ϵ��ַ*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**��ϵ�绰*/
	public String getTel() {
		return tel;
	}
	/**��ϵ�绰*/
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**¼������*/
	public Date getGmtEntry() {
		return gmtEntry;
	}
	/**¼������*/
	public void setGmtEntry(Date gmtEntry) {
		this.gmtEntry = gmtEntry;
	}
	/**������*/
	public String getOperator() {
		return operator;
	}
	/**������*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**����ʱ��*/
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**����ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**����޸�ʱ��*/
	public Date getGmtModify() {
		return gmtModify;
	}
	/**����޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}