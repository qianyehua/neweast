package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 系统用户表
 * @author lxh
 * @version 2014-10-29 17:44:08
 */
public class SystemUser extends Pagination<SystemUser> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6358137734180445917L;
	//pk,seq
	private Long id;
	//登录名
	private String loginName;
	//真实姓名
	private String realName;
	//密码
	private String password;
	//确认密码
	private String rePassword;
	//原密码
	private String oldPassword;
	//Email
	private String email;
	//固定电话
	private String tel;
	//手机
	private String mobile;
	//上次登录时间
	private Date gmtLastLogin;
	//上次登录IP
	private String lastLoginIp;
	//本次登录时间
	private Date gmtCurrentLogin;
	//本次登录IP
	private String currentLoginIp;
	//登录次数默认0
	private Integer loginCount;
	//操作员
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	private Short isDisabled;

	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置登录名*/
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**获取登录名*/
	public String getLoginName() {
		return this.loginName;
	}
	
	/**设置真实姓名*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**获取真实姓名*/
	public String getRealName() {
		return this.realName;
	}
	
	/**设置密码*/
	public void setPassword(String password) {
		this.password = password;
	}
	/**获取密码*/
	public String getPassword() {
		return this.password;
	}
	
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**设置Email*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**获取Email*/
	public String getEmail() {
		return this.email;
	}
	
	/**设置固定电话*/
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**获取固定电话*/
	public String getTel() {
		return this.tel;
	}
	
	/**设置手机*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**获取手机*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**设置上次登录时间*/
	public void setGmtLastLogin(Date gmtLastLogin) {
		this.gmtLastLogin = gmtLastLogin;
	}
	/**获取上次登录时间*/
	public Date getGmtLastLogin() {
		return this.gmtLastLogin;
	}
	
	/**设置上次登录IP*/
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**获取上次登录IP*/
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	/**设置本次登录时间*/
	public void setGmtCurrentLogin(Date gmtCurrentLogin) {
		this.gmtCurrentLogin = gmtCurrentLogin;
	}
	/**获取本次登录时间*/
	public Date getGmtCurrentLogin() {
		return this.gmtCurrentLogin;
	}
	
	/**设置本次登录IP*/
	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}
	/**获取本次登录IP*/
	public String getCurrentLoginIp() {
		return this.currentLoginIp;
	}
	
	/**设置登录次数默认0*/
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**获取登录次数默认0*/
	public Integer getLoginCount() {
		return this.loginCount;
	}
	
	/**设置操作员*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**获取操作员*/
	public String getOperator() {
		return this.operator;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置最后修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取最后修改时间*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	public Short getIsDisabled() {
		return isDisabled;
	}
	public void setIsDisabled(Short isDisabled) {
		this.isDisabled = isDisabled;
	}
	
}