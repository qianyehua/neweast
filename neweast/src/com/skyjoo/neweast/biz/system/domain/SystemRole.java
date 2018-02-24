package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;


/**
 * ϵͳ��ɫ��
 * @author lxh
 * @version 2014-10-29 17:45:24
 */
public class SystemRole extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6442680380900166666L;
	//pk,seq
	private Long id;
	//����
	private String name;
	//����
	private String description;
	//����Ա
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	
	private List<SystemFunction> systemFunctionList;

    private boolean selected;
   
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
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
	
	/**��������*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**��ȡ����*/
	public String getDescription() {
		return this.description;
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

	public List<SystemFunction> getSystemFunctionList() {
		return systemFunctionList;
	}

	public void setSystemFunctionList(List<SystemFunction> systemFunctionList) {
		this.systemFunctionList = systemFunctionList;
	}
	
}