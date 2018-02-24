package com.skyjoo.neweast.biz.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;

/**
 * ��Ա���������
 * @author lxh
 * @version 2015-04-13 10:38:20
 */
public class ShopAuthApply extends DomainBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7862558225255328918L;
	//seq,pk
	private Long id;
	//��ԱID
	private Long accountId;
	//��¼ID�����ʵ�ַ
	private String loginId;
	//0����1��ҵ
	private Integer type;
	//����
	private String region;
	//����
	private String realName;
	//Ӣ����
	private String enName;
	//֤�����ͣ�P01���֤BӪҵִ��
	private String licenseType;
	//֤����
	private String license;
	//֤����Ч��
	private Date gmtLicenseExpiry;
	//�Ա�0����1��Ů2:����
	private Integer gender;
	//������ҵ
	private String major;
	//ʡ�ݣ����ֵ����
	private String province;
	//���У����ֵ����
	private String city;
	//��ϸ��ַ
	private String address;
	//�ֻ�����
	private String mobile;
	//��������������á�|���ָ�
	private String attachment;
	//��������
	private Date gmtApply;
	//״̬-2������-1���ʧ��0�����1��˳ɹ�
	private Integer status;
	//��ע
	private String memo;
	//������
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	//��ҵ������Ϣ
	private ShopAuthApplyOrg applyOrg;
	
	//���ʱ��
	private Date gmtAccepted;
	
	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**���û�ԱID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**��ȡ��ԱID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	/**���õ�¼ID�����ʵ�ַ*/
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**��ȡ��¼ID�����ʵ�ַ*/
	public String getLoginId() {
		return this.loginId;
	}
	
	/**����0����1��ҵ*/
	public void setType(Integer type) {
		this.type = type;
	}
	public void setType(EnumShopAuthType type) {
		this.type = type.getValue();
	}
	/**��ȡ0����1��ҵ*/
	public Integer getType() {
		return this.type;
	}
	
	/**���õ���*/
	public void setRegion(String region) {
		this.region = region;
	}
	/**��ȡ����*/
	public String getRegion() {
		return this.region;
	}
	
	/**��������*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**��ȡ����*/
	public String getRealName() {
		return this.realName;
	}
	
	/**����Ӣ����*/
	public void setEnName(String enName) {
		this.enName = enName;
	}
	/**��ȡӢ����*/
	public String getEnName() {
		if(StringUtil.isNotBlank(this.enName)) {
			this.enName = this.enName.replace("_", " ");
		}
		return this.enName;
	}
	
	/**����֤�����ͣ�P01���֤BӪҵִ��*/
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	/**��ȡ֤�����ͣ�P01���֤BӪҵִ��*/
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
	
	public Date getGmtLicenseExpiry() {
		return this.gmtLicenseExpiry;
	}
	public void setGmtLicenseExpiry(Date gmtLicenseExpiry) {
		this.gmtLicenseExpiry = gmtLicenseExpiry;
	}
	/**�����Ա�0����1��Ů2:����*/
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**��ȡ�Ա�0����1��Ů2:����*/
	public Integer getGender() {
		return this.gender;
	}
	
	/**���ô�����ҵ*/
	public void setMajor(String major) {
		this.major = major;
	}
	/**��ȡ������ҵ*/
	public String getMajor() {
		return this.major;
	}
	
	/**����ʡ�ݣ����ֵ����*/
	public void setProvince(String province) {
		this.province = province;
	}
	/**��ȡʡ�ݣ����ֵ����*/
	public String getProvince() {
		return this.province;
	}
	
	/**���ó��У����ֵ����*/
	public void setCity(String city) {
		this.city = city;
	}
	/**��ȡ���У����ֵ����*/
	public String getCity() {
		return this.city;
	}
	
	/**������ϸ��ַ*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**��ȡ��ϸ��ַ*/
	public String getAddress() {
		return this.address;
	}
	
	/**�����ֻ�����*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**��ȡ�ֻ�����*/
	public String getMobile() {
		return this.mobile;
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
	
	/**������������*/
	public void setGmtApply(Date gmtApply) {
		this.gmtApply = gmtApply;
	}
	/**��ȡ��������*/
	public Date getGmtApply() {
		return this.gmtApply;
	}
	
	/**����״̬-2������-1���ʧ��0�����1��˳ɹ�*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumShopAuthStatus status) {
		this.status = status.getValue();
	}
	/**��ȡ״̬-2������-1���ʧ��0�����1��˳ɹ�*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**���ñ�ע*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**��ȡ��ע*/
	public String getMemo() {
		return this.memo;
	}
	
	/**���ò�����*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**��ȡ������*/
	public String getOperator() {
		return this.operator;
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
	public ShopAuthApplyOrg getApplyOrg() {
		return applyOrg;
	}
	public void setApplyOrg(ShopAuthApplyOrg applyOrg) {
		this.applyOrg = applyOrg;
	}
	
    public Date getGmtAccepted() {
        return gmtAccepted;
    }
    public void setGmtAccepted(Date gmtAccepted) {
        this.gmtAccepted = gmtAccepted;
    }
	
	/**
	 * ����
	 * @return
	 */
	public boolean isPersonal() {
		return EnumShopAuthType.PERSONAL.getValue().equals(this.type);
	}
	
	/**
	 * ��ҵ
	 * @return
	 */
	public boolean isCompany() {
		return EnumShopAuthType.COMPANY.getValue().equals(this.type);
	}
	
	public boolean isSuccess() {
		return EnumShopAuthStatus.AUDIT_SUCCESS.getValue().equals(this.status);
	}
	
	public boolean isFailed() {
		return EnumShopAuthStatus.AUDIT_FAILED.getValue().equals(this.status);
	}
	
	public boolean isAuditing() {
		return EnumShopAuthStatus.AUDITING.getValue().equals(this.status);
	}

}