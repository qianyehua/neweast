package com.skyjoo.neweast.biz.auth.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * ����������
 * @author LZW
 * @version 2015-04-16 09:09:33
 */
public class AuthCert extends Pagination<AuthCert> {

	private static final long serialVersionUID = 1683664023486342460L;
	
	//seq,pk
	private Long id;
	//��������ID
	private long instID;
	//֤����
	private String certNo;
	//֤��ͼƬ
	private String certPic;
	//¼������
	private Date gmtEntry;
	//������
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	
	//��ѯ ��ʼʱ��
	String startDate;
	//��ѯ ��ֹʱ��
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