package com.skyjoo.neweast.biz.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ϵͳ���ܱ�
 * @author lxh
 * @version 2014-10-29 17:16:36
 */
public class SystemFunction extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3320817601236631458L;
	//PK
	private Long id;
	//��������ID
	private Long parentId;
	//����
	private String name;
	//���ӵ�ַ
	private String url;
	//����
	private String description;
	//˳��
	private Integer ordering;
	//�Ƿ�˵���0��1��
	private Integer isMenu;
	//0������1��ɾ��
	private Integer isDeleted;
	//�ܷ�ɾ����true��;false����
	private boolean canDeleted;
	//����Ա
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	
	//�ӹ���
	private List<SystemFunction> subfunctions = new ArrayList<SystemFunction>();

	/**����PK*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡPK*/
	public Long getId() {
		return this.id;
	}
	
	/**���ø�������ID*/
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**��ȡ��������ID*/
	public Long getParentId() {
		return this.parentId;
	}
	
	/**��������*/
	public void setName(String name) {
		this.name = name;
	}
	/**��ȡ����*/
	public String getName() {
		return this.name;
	}
	
	/**�������ӵ�ַ*/
	public void setUrl(String url) {
		this.url = url;
	}
	/**��ȡ���ӵ�ַ*/
	public String getUrl() {
		return this.url;
	}
	
	/**��������*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**��ȡ����*/
	public String getDescription() {
		return this.description;
	}
	
	/**����˳��*/
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	/**��ȡ˳��*/
	public Integer getOrdering() {
		return this.ordering;
	}
	
	/**�����Ƿ�˵���0��1��*/
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	/**��ȡ�Ƿ�˵���0��1��*/
	public Integer getIsMenu() {
		return this.isMenu;
	}
	
	/**����0������1��ɾ��*/
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**��ȡ0������1��ɾ��*/
	public Integer getIsDeleted() {
		return this.isDeleted;
	}
	
	public boolean isCanDeleted() {
		return canDeleted;
	}
	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
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
	
	/**��ȡ�ӹ���*/
	public List<SystemFunction> getSubfunctions() {
		return subfunctions;
	}
	/**�����ӹ���*/
	public void setSubfunctions(List<SystemFunction> subfunctions) {
		this.subfunctions = subfunctions;
	}
	/**
	 * ����ӹ���
	 * @param function
	 */
	public void addSubFunction(SystemFunction function) {
		this.subfunctions.add(function);
	}
	/**
	 * ��Ӷ���ӹ���
	 * @param function
	 */
	public void addSubFunction(List<SystemFunction> functions) {
		this.subfunctions.addAll(functions);
	}	
	
}