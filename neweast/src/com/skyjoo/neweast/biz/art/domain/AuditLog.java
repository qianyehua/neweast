package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class AuditLog {
	
	/**seq,pk*/
	private Long id;
	/**审核类型 art：艺术品 shop_img：店铺图片*/
	private String type = "art";
	/**关联ID*/
	private long relatedID;
	/**审核内容*/
	private String auditContent ;
	/**状态 p：通过 r：拒绝*/
	private String status="R";

	/**备注 主要是审核不通过原因*/
	private String memo ;
	/**审核人*/
	private String auditor ;
	/**创建时间*/
	private Date gmtCreate ;
	/**最后修改时间*/
	private Date gmtModify ;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getRelatedID() {
		return relatedID;
	}

	public void setRelatedID(long relatedID) {
		this.relatedID = relatedID;
	}

	public String getAuditContent() {
		return auditContent;
	}

	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
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
	
	
}
