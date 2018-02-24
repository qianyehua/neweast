package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;


/**
 * ����ģ���
 * @author LZW
 *  */
public class ShopTemplate  extends Pagination<ShopAuthApply>{

	private static final long serialVersionUID = 5784464809876621563L;
	//seq,pk
	private Long id;
	//����
	private String title;
	//ģ������
	private String templateName;
	//Ԥ��ͼ
	private String previewPic;
	//Ԥ��ҳ��URL
	private String previewUrl;
	//��Ҫ˵��
	private String desp;
	//��ϸ˵��
	private String description;
	//״̬ 0δ���� 1������-1��ɾ��
	private Integer status;
	//����ʱ��
	private Date gmtCreate;
	//�޸�ʱ��
	private Date gmtModify;

	//���̴������ڣ���ʼ���ڣ��������ڣ�
	private String gmtCreateStart;
	private String gmtCreateEnd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getPreviewPic() {
		return previewPic;
	}
	public void setPreviewPic(String previewPic) {
		this.previewPic = previewPic;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getGmtCreateStart() {
		return gmtCreateStart;
	}
	public void setGmtCreateStart(String gmtCreateStart) {
		this.gmtCreateStart = gmtCreateStart;
	}
	public String getGmtCreateEnd() {
		return gmtCreateEnd;
	}
	public void setGmtCreateEnd(String gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}
	
}