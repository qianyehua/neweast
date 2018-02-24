package com.skyjoo.neweast.biz.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;

/**
 * ���꾭���˱�
 * @author lxh
 * @version 2015-04-13 10:38:35
 */
public class ShopAuthApplyOrg extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 369988508618690112L;
	//seq,pk
	private Long id;
	//����ID
	private Long applyId;
	//����
	private String realName;
	//֤�����ͣ�P01���֤
	private String licenseType;
	//֤����
	private String license;
	//��������������á�|���ָ�
	private String attachment;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;

	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**��������ID*/
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	/**��ȡ����ID*/
	public Long getApplyId() {
		return this.applyId;
	}
	
	/**��������*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**��ȡ����*/
	public String getRealName() {
		return this.realName;
	}
	
	/**����֤�����ͣ�P01���֤*/
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	/**��ȡ֤�����ͣ�P01���֤*/
	public String getLicenseType() {
		return this.licenseType;
	}
	
	/**����֤����*/
	public void setLicense(String license) {
		this.license = license;
	}
	/**��ȡ֤����*/
	public String getLicense() {
		return this.license;
	}
	
	/**���ø�������������á�|���ָ�*/
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**��ȡ��������������á�|���ָ�*/
	public String getAttachment() {
		return this.attachment;
	}
	
	public List<String> getAttachmentList() {
		List<String> list = new ArrayList<String>();
		if(StringUtil.isNotBlank(this.attachment)) {
			for (String atta : this.attachment.split("\\|")) {
				list.add(atta);
			}
		}
		return list;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**��������޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ����޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
}