package com.skyjoo.neweast.biz.auth.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 鉴定数据 QUERY
 * @author LZW
 * @version 2015-04-16 09:09:33
 */
public class AuthCertQurty extends Pagination<AuthCertQurty> {

	private static final long serialVersionUID = 1683664027486642461L;
	
	//鉴定证书ID
	private long certID;
	
	//鉴定机构 名称
	private String instName;

	//鉴定机构ID
	private long instID=0;
	private String inst_id;

	//证书编号
	private String certNo;
	
	//证书图片
	private String certPic;
	

	//录入日期
	private Date gmtEntry;
	
	//查询 起始时间
	private String startDate;
	//查询 截止时间
	private String endDate;
	
	public long getCertID() {
		return certID;
	}
	public void setCertID(long certID) {
		this.certID = certID;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
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
	public Date getGmtEntry() {
		return gmtEntry;
	}
	public void setGmtEntry(Date gmtEntry) {
		this.gmtEntry = gmtEntry;
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
	public String getCertPic() {
		return certPic;
	}
	public void setCertPic(String certPic) {
		this.certPic = certPic;
	}
	public String getInst_id() {
		return inst_id;
	}
	public void setInst_id(String inst_id) {
		this.inst_id = inst_id;
	}
}