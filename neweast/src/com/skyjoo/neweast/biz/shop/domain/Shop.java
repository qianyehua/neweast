package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;


/**
 * ���̱�
 * @author lxh
 * @version 2015-04-14 11:54:25
 */
public class Shop extends DomainBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5783862809876621563L;
	//seq,pk
	private Long id;
	//��������
	private String name;
	//��ԱID
	private Long accountId;
	private String sellerName;
	private String email;
	//����LOGO��ַ
	private String logoPath;
	//���̽���
	private String description;
	//��ϵ�ֻ�
	private String mobile;
	//ʡ��
	private String province;
	//����
	private String city;
	//��ַ
	private String address;
	//״̬1������-1���ر�
	private Integer status;
	//����Ʒ������˿���Y����N����
	private String atrAuditOn;
	//ͼƬ������˿���Y����N����
	private String imgAuditOn;
	//��ע
	private String memo;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	//����
	private Integer salesVolume;
    //��Ӫҵ��
    private String  mainBiz;
    
	private List<ShopBusinessHours> businessHours;

	/**��ȡ��Ӫҵ��*/
	public String getMainBiz() {
		return mainBiz;
	}
	/**������Ӫҵ��*/
	public void setMainBiz(String mainBiz) {
		this.mainBiz = mainBiz;
	}
	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**���õ�������*/
	public void setName(String name) {
		this.name = name;
	}
	/**��ȡ��������*/
	public String getName() {
		return this.name;
	}
	
	/**���û�ԱID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**��ȡ��ԱID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**���õ���LOGO��ַ*/
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	/**��ȡ����LOGO��ַ*/
	public String getLogoPath() {
		return this.logoPath;
	}
	
	/**���õ��̽���*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**��ȡ���̽���*/
	public String getDescription() {
		return this.description;
	}
	
	/**������ϵ�ֻ�*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**��ȡ��ϵ�ֻ�*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**����ʡ��*/
	public void setProvince(String province) {
		this.province = province;
	}
	/**��ȡʡ��*/
	public String getProvince() {
		return this.province;
	}
	
	/**���ó���*/
	public void setCity(String city) {
		this.city = city;
	}
	/**��ȡ����*/
	public String getCity() {
		return this.city;
	}
	
	/**���õ�ַ*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**��ȡ��ַ*/
	public String getAddress() {
		return this.address;
	}
	
	/**����״̬1������-1���ر�*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumShopStatus status) {
		this.status = status.getValue();
	}
	/**��ȡ״̬1������-1���ر�*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**��������Ʒ������˿���Y����N����*/
	public void setAtrAuditOn(String atrAuditOn) {
		this.atrAuditOn = atrAuditOn;
	}
	/**��ȡ����Ʒ������˿���Y����N����*/
	public String getAtrAuditOn() {
		return this.atrAuditOn;
	}
	
	/**����ͼƬ������˿���Y����N����*/
	public void setImgAuditOn(String imgAuditOn) {
		this.imgAuditOn = imgAuditOn;
	}
	/**��ȡͼƬ������˿���Y����N����*/
	public String getImgAuditOn() {
		return this.imgAuditOn;
	}
	
	/**���ñ�ע*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**��ȡ��ע*/
	public String getMemo() {
		return this.memo;
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
	
	/**��ȡ����*/
	public Integer getSalesVolume() {
		return salesVolume;
	}
	/**��������*/
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	public List<ShopBusinessHours> getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(List<ShopBusinessHours> businessHours) {
		this.businessHours = businessHours;
	}
	
	public boolean isNormal() {
		return EnumShopStatus.NORMAL.getValue().equals(this.status);
	}
	
	public boolean isClosed() {
		return EnumShopStatus.CLOSED.getValue().equals(this.status);
	}
	
    public boolean isUpdate() {
        return this.id != null;
    }
}