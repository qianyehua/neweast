package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * ϵͳ�û���
 * @author lxh
 * @version 2014-10-29 17:44:08
 */
public class SystemUser extends Pagination<SystemUser> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6358137734180445917L;
	//pk,seq
	private Long id;
	//��¼��
	private String loginName;
	//��ʵ����
	private String realName;
	//����
	private String password;
	//ȷ������
	private String rePassword;
	//ԭ����
	private String oldPassword;
	//Email
	private String email;
	//�̶��绰
	private String tel;
	//�ֻ�
	private String mobile;
	//�ϴε�¼ʱ��
	private Date gmtLastLogin;
	//�ϴε�¼IP
	private String lastLoginIp;
	//���ε�¼ʱ��
	private Date gmtCurrentLogin;
	//���ε�¼IP
	private String currentLoginIp;
	//��¼����Ĭ��0
	private Integer loginCount;
	//����Ա
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	private Short isDisabled;

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**���õ�¼��*/
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**��ȡ��¼��*/
	public String getLoginName() {
		return this.loginName;
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
	public void setPassword(String password) {
		this.password = password;
	}
	/**��ȡ����*/
	public String getPassword() {
		return this.password;
	}
	
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**����Email*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**��ȡEmail*/
	public String getEmail() {
		return this.email;
	}
	
	/**���ù̶��绰*/
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**��ȡ�̶��绰*/
	public String getTel() {
		return this.tel;
	}
	
	/**�����ֻ�*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**��ȡ�ֻ�*/
	public String getMobile() {
		return this.mobile;
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
	
	/**���ñ��ε�¼ʱ��*/
	public void setGmtCurrentLogin(Date gmtCurrentLogin) {
		this.gmtCurrentLogin = gmtCurrentLogin;
	}
	/**��ȡ���ε�¼ʱ��*/
	public Date getGmtCurrentLogin() {
		return this.gmtCurrentLogin;
	}
	
	/**���ñ��ε�¼IP*/
	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}
	/**��ȡ���ε�¼IP*/
	public String getCurrentLoginIp() {
		return this.currentLoginIp;
	}
	
	/**���õ�¼����Ĭ��0*/
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**��ȡ��¼����Ĭ��0*/
	public Integer getLoginCount() {
		return this.loginCount;
	}
	
	/**���ò���Ա*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**��ȡ����Ա*/
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
	public Short getIsDisabled() {
		return isDisabled;
	}
	public void setIsDisabled(Short isDisabled) {
		this.isDisabled = isDisabled;
	}
	
}