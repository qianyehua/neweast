package com.skyjoo.neweast.biz.subject.domain;

import java.util.Date;


import com.skyjoo.neweast.biz.common.page.Pagination;

public class Subject extends Pagination<Subject>{
	private static final long serialVersionUID = 1234564728789L;
	//seq,pk
	private Long id;
	//ר������
	private String  subjectName;
	//ר��ͼƬ·��
	private String subjectPic;
	//ר������
	private Long subjectOrder;
	//����ʱ��
	private Date  gmt_Create;
	//�޸�ʱ��
	private Date gmt_Modify;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectPic() {
		return subjectPic;
	}
	public void setSubjectPic(String subjectPic) {
		this.subjectPic = subjectPic;
	}
	public Long getSubjectOrder() {
		return subjectOrder;
	}
	public void setSubjectOrder(Long subjectOrder) {
		this.subjectOrder = subjectOrder;
	}
	public Date getGmt_Create() {
		return gmt_Create;
	}
	public void setGmt_Create(Date gmt_Create) {
		this.gmt_Create = gmt_Create;
	}
	public Date getGmt_Modify() {
		return gmt_Modify;
	}
	public void setGmt_Modify(Date gmt_Modify) {
		this.gmt_Modify = gmt_Modify;
	}
	
}
