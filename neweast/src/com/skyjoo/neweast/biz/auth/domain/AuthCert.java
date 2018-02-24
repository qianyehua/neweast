package com.skyjoo.neweast.biz.auth.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 鉴定机构表
 * @author LZW
 * @version 2015-04-16 09:09:33
 */
public class AuthCert extends Pagination<AuthCert> {

	private static final long serialVersionUID = 1683664023486342460L;
	
	//seq,pk
	private Long id;
	//鉴定机构ID
	private long instID;
	//证书编号
	private String certNo;
	//证书图片
	private String certPic;
	//录入日期
	private Date gmtEntry;
	//操作人
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	
	//查询 起始时间
	String startDate;
	//查询 截止时间
	String endDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getInstID() {
		return instID;
	}
	public void setInstID(long instID) {
		this.instID = instID;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCertPic() {
		return certPic;
	}
	public void setCertPic(String certPic) {
		this.certPic = certPic;
	}
	public Date getGmtEntry() {
		return gmtEntry;
	}
	public void setGmtEntry(Date gmtEntry) {
		this.gmtEntry = gmtEntry;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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