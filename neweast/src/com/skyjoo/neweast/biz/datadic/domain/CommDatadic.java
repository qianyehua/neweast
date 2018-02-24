package com.skyjoo.neweast.biz.datadic.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * �����ֵ��
 * @author lxh
 * @version 2014-11-03 10:11:33
 */
public class CommDatadic extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6263412340387365532L;
	//���к�ID
	private Long id;
	//����
	private String name;
	//����
	private String code;
	//ֵ
	private String value;
	//������������ͬ���ԵĿ��Խ��з������
	private String groupName;
	//����ID
	private Long parentId;
	//����
	private Integer ordering;
	//��ע
	private String memo;
	//����Ա
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//�޸�ʱ��
	private Date gmtModify;

	/**�������к�ID*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡ���к�ID*/
	public Long getId() {
		return this.id;
	}
	
	/**��������*/
	public void setName(String name) {
		this.name = name;
	}
	/**��ȡ����*/
	public String getName() {
		return this.name;
	}
	
	/**���ô���*/
	public void setCode(String code) {
		this.code = code;
	}
	/**��ȡ����*/
	public String getCode() {
		return this.code;
	}
	
	/**����ֵ*/
	public void setValue(String value) {
		this.value = value;
	}
	/**��ȡֵ*/
	public String getValue() {
		return this.value;
	}
	
	/**����������������ͬ���ԵĿ��Խ��з������*/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**��ȡ������������ͬ���ԵĿ��Խ��з������*/
	public String getGroupName() {
		return this.groupName;
	}
	
	/**���ø���ID*/
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**��ȡ����ID*/
	public Long getParentId() {
		return this.parentId;
	}
	
	/**��������*/
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	/**��ȡ����*/
	public Integer getOrdering() {
		return this.ordering;
	}
	
	/**���ñ�ע*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**��ȡ��ע*/
	public String getMemo() {
		return this.memo;
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
	
	/**�����޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ�޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
}