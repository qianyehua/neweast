package com.skyjoo.neweast.biz.shop.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;

/**
 * 开店认证分页查询
 * @author lxh
 *
 */
public class ShopAuthApplyQuery extends Pagination<ShopAuthApply> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4277806700924897515L;
	
	//登录ID，电邮地址
	private String loginId;
	//0个人1企业
	private Integer type;
	//申请日期
	private String gmtApplyStart;
	private String gmtApplyEnd;
	//状态-2黑名单-1审核失败0审核中1审核成功
	private Integer status;
	
	/**设置登录ID，电邮地址*/
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**获取登录ID，电邮地址*/
	public String getLoginId() {
		return this.loginId;
	}
	
	/**设置0个人1企业*/
	public void setType(Integer type) {
		this.type = type;
	}
	public void setType(EnumShopAuthType type) {
		this.type = type.getValue();
	}
	/**获取0个人1企业*/
	public Integer getType() {
		return this.type;
	}
	
	/**设置状态-2黑名单-1审核失败0审核中1审核成功*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**获取状态-2黑名单-1审核失败0审核中1审核成功*/
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
