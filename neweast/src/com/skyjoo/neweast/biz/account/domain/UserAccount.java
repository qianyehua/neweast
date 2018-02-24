package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;
import com.skyjoo.wudadao.neweast.dto.UserAccountDTO;

/**
 * 会员账户表
 * @author lxh
 * @version 2015-08-18 14:59:52
 */
public class UserAccount extends DomainBase {
	
	private static final long serialVersionUID = 5537138256243097399L;
		
	//seq,pk
	private Long id;
	//资金账号
	private String fundAccount;
	//持仓账号
	private String stockAccount;
	//真实姓名
	private String realName;
	//邮箱
	private String email;
	//手机号码
	private String mobile;
	//国家
	private String country;
	//上次登录时间
	private Date gmtLastLogin;
	//上次登录IP
	private String lastLoginIp;
	//帐号状态0：初始化1：正常-1：销户
	private Integer status;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	   //证件类型
    private String licenseType;
    //证件号
    private String license;
    //性别 0：男 1：女 2: 其他
    private Integer gender;
    //生日
    private Date birthday;
    //昵称
    private String nickName;
    //用户类型
    private String accountType;
    //用户头像
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
	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置资金账号*/
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**获取资金账号*/
	public String getFundAccount() {
		return this.fundAccount;
	}
	
	/**设置持仓账号*/
	public void setStockAccount(String stockAccount) {
		this.stockAccount = stockAccount;
	}
	/**获取持仓账号*/
	public String getStockAccount() {
		return this.stockAccount;
	}
	
	/**设置真实姓名*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**获取真实姓名*/
	public String getRealName() {
		return this.realName;
	}
	
	/**设置邮箱*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**获取邮箱*/
	public String getEmail() {
		return this.email;
	}
	
	/**设置手机号码*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**获取手机号码*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**设置国家*/
	public void setCountry(String country) {
		this.country = country;
	}
	/**获取国家*/
	public String getCountry() {
		return this.country;
	}
	
	/**设置上次登录时间*/
	public void setGmtLastLogin(Date gmtLastLogin) {
		this.gmtLastLogin = gmtLastLogin;
	}
	/**获取上次登录时间*/
	public Date getGmtLastLogin() {
		return this.gmtLastLogin;
	}
	
	/**设置上次登录IP*/
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**获取上次登录IP*/
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	/**设置帐号状态0：初始化1：正常-1：销户*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**获取帐号状态0：初始化1：正常-1：销户*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置最后修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取最后修改时间*/
	public Date getGmtModify() {
		return this.gmtModify;
	}

	/**
	 * 会员正常状态
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