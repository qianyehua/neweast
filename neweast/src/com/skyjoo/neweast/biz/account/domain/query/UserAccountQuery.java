package com.skyjoo.neweast.biz.account.domain.query;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;

/**
 * 会员分页查询
 * @author lxh
 *
 */
public class UserAccountQuery extends Pagination<UserAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7935537553804563714L;
	//电邮地址
	private String email;
	//手机号码
	private String mobile;
	//地区
	private String country;
	//状态0:待手机验证1:待设置登录信息2:待激活3:正常
	private Integer status;
	//开户时间
	private String gmtOpenStart;
	//开户时间
	private String gmtOpenEnd;
	//真实姓名
	private String realName;
	//持仓账号
	private String stockAccount;
	
	/**设置电邮地址*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**获取电邮地址*/
	public String getEmail() {
		return this.email;
	}
	
	/**设置手机号码*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**获取手机号码*/
	public String getMobile() {
		return this.mobile;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**设置状态0:待手机验证1:待设置登录信息2:待激活3:正常*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumUserAccountStatus status) {
		this.status = status.getValue();
	}
	/**获取状态0:待手机验证1:待设置登录信息2:待激活3:正常*/
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
	
	/**设置真实姓名*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**获取真实姓名*/
	public String getRealName() {
		return this.realName;
	}
	
	/**设置持仓账号*/
	public void setStockAccount(String stockAccount) {
		this.stockAccount = stockAccount;
	}
	/**获取持仓账号*/
	public String getStockAccount() {
		return this.stockAccount;
	}
	
}
