package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.eyeieye.melos.util.StringUtil;

public class ArtPropertyValue {
	/**
	 * pk,seq
	 */
	private Long id;  
	/**
	 * ����ƷID
	 */
	private Long artId;
	/**
	 * ����ID
	 */
	private Long propertyId;
	/**
	 * 	1��ѡ����(ID�ԡ�,������)2��������ֱ�Ӽ�¼
	 */
	private String artOption;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
	private Date gmtModify;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getArtOption() {
		return artOption;
	}
	public void setArtOption(String artOption) {
		this.artOption = artOption;
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
	public String[] getOptionList() {
        if (StringUtil.isBlank(this.artOption)) {
            return null;
        }
        String[] options = this.artOption.split(",");
        return options;
    }
	
	public boolean checkOption(Long optionId){
		String[] options=getOptionList();
		if(null!=options&&options.length>0){
			for(String optionStr:options){
				if(optionStr.equals(String.valueOf(optionId))){
					return false;
				}
			}
		}
		return true;
	}
	
}
