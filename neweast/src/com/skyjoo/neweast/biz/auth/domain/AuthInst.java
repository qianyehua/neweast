package com.skyjoo.neweast.biz.auth.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 鉴定机构表
 * @author LZW
 * @version 2015-04-09 09:37:11
 */
public class AuthInst extends Pagination<AuthInst> {

	private static final long serialVersionUID = 1683664086486342460L;
	
	/**pk,seq*/
	private Long id;
	/**登录账号*/
	private String account;
	/**密码*/
	private String password;
	/**机构名称*/
	private String name;
	/**联系地址*/
	private String address;
	/**联系电话*/
	private String tel;
	/**录入日期*/
	private Date gmtEntry;
	/**操作人*/
	private String operator;
	/**创建时间*/
	private Date gmtCreate;
	/**最后修改时间*/
	private Date gmtModify;
	/**查询  开始时间 **/
	private String startDate;
	/**查询  结束时间**/
	private String endDate;
	
	
	/**pk,seq*/
	public Long getId() {
		return id;
	}
	/**pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**登录账号*/
	public String getAccount() {
		return account;
	}
	/**登录账号*/
	public void setAccount(String account) {
		this.account = account;
	}
	/**密码*/
	public String getPassword() {
		return password;
	}
	/**密码*/
	public void setPassword(String password) {
		this.password = password;
	}
	/**机构名称*/
	public String getName() {
		return name;
	}
	/**机构名称*/
	public void setName(String name) {
		this.name = name;
	}
	/**联系地址*/
	public String getAddress() {
		return address;
	}
	/**联系地址*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**联系电话*/
	public String getTel() {
		return tel;
	}
	/**联系电话*/
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**录入日期*/
	public Date getGmtEntry() {
		return gmtEntry;
	}
	/**录入日期*/
	public void setGmtEntry(Date gmtEntry) {
		this.gmtEntry = gmtEntry;
	}
	/**操作人*/
	public String getOperator() {
		return operator;
	}
	/**操作人*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**创建时间*/
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**最后修改时间*/
	public Date getGmtModify() {
		return gmtModify;
	}
	/**最后修改时间*/
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