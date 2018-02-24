package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;
import com.skyjoo.wudadao.neweast.dto.UserAccountDTO;

/**
 * ��Ա�˻���
 * @author lxh
 * @version 2015-08-18 14:59:52
 */
public class UserAccount extends DomainBase {
	
	private static final long serialVersionUID = 5537138256243097399L;
		
	//seq,pk
	private Long id;
	//�ʽ��˺�
	private String fundAccount;
	//�ֲ��˺�
	private String stockAccount;
	//��ʵ����
	private String realName;
	//����
	private String email;
	//�ֻ�����
	private String mobile;
	//����
	private String country;
	//�ϴε�¼ʱ��
	private Date gmtLastLogin;
	//�ϴε�¼IP
	private String lastLoginIp;
	//�ʺ�״̬0����ʼ��1������-1������
	private Integer status;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	   //֤������
    private String licenseType;
    //֤����
    private String license;
    //�Ա� 0���� 1��Ů 2: ����
    private Integer gender;
    //����
    private Date birthday;
    //�ǳ�
    private String nickName;
    //�û�����
    private String accountType;
    //�û�ͷ��
    private String portrait;

	public UserAccount() {}
	
	public UserAccount(UserAccountDTO account) {
		this.fundAccount = account.getFundAccount();
		this.stockAccount = account.getStockAccount();
		this.realName = account.getRealName();
		this.email = account.getEmail();
		this.mobile = account.getMobile();
		this.country = account.getCountry();
		this.licenseType = account.getLicenseType();
		this.license = account.getLicense();
		this.gender = account.getGender();
		this.birthday = account.getBirthday();
		this.status = EnumUserAccountStatus.NORMAL.getValue();
		this.accountType= account.getAccountType();
	}
	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**�����ʽ��˺�*/
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**��ȡ�ʽ��˺�*/
	public String getFundAccount() {
		return this.fundAccount;
	}
	
	/**���óֲ��˺�*/
	public void setStockAccount(String stockAccount) {
		this.stockAccount = stockAccount;
	}
	/**��ȡ�ֲ��˺�*/
	public String getStockAccount() {
		return this.stockAccount;
	}
	
	/**������ʵ����*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**��ȡ��ʵ����*/
	public String getRealName() {
		return this.realName;
	}
	
	/**��������*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**��ȡ����*/
	public String getEmail() {
		return this.email;
	}
	
	/**�����ֻ�����*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**��ȡ�ֻ�����*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**���ù���*/
	public void setCountry(String country) {
		this.country = country;
	}
	/**��ȡ����*/
	public String getCountry() {
		return this.country;
	}
	
	/**�����ϴε�¼ʱ��*/
	public void setGmtLastLogin(Date gmtLastLogin) {
		this.gmtLastLogin = gmtLastLogin;
	}
	/**��ȡ�ϴε�¼ʱ��*/
	public Date getGmtLastLogin() {
		return this.gmtLastLogin;
	}
	
	/**�����ϴε�¼IP*/
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**��ȡ�ϴε�¼IP*/
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	/**�����ʺ�״̬0����ʼ��1������-1������*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**��ȡ�ʺ�״̬0����ʼ��1������-1������*/
	public Integer getStatus() {
		return this.status;
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

	/**
	 * ��Ա����״̬
	 * @return
	 */
	public boolean isNormal() {
		return EnumUserAccountStatus.NORMAL.getValue().equals(this.status);
	}

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    
}