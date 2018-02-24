package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class AuditLog {
	
	/**seq,pk*/
	private Long id;
	/**������� art������Ʒ shop_img������ͼƬ*/
	private String type = "art";
	/**����ID*/
	private long relatedID;
	/**�������*/
	private String auditContent ;
	/**״̬ p��ͨ�� r���ܾ�*/
	private String status="R";

	/**��ע ��Ҫ����˲�ͨ��ԭ��*/
	private String memo ;
	/**�����*/
	private String auditor ;
	/**����ʱ��*/
	private Date gmtCreate ;
	/**����޸�ʱ��*/
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
