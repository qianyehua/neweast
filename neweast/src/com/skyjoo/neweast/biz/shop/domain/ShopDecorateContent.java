package com.skyjoo.neweast.biz.shop.domain;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hundsun.wudadao.common.DomainBase;

/**
 * ����װ�����ݱ�
 * @author lxh
 * @version 2015-07-27 10:52:57
 */
public class ShopDecorateContent extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7168149298057979522L;
	//seq,pk
	private Long id;
	//װ��ID
	private Long decorateId;
	//ҳ������:index��detail
	private String pageType;
	//�������ͣ�Title���У�Guide������Bannerͨ����Seller_recommend�ƹ��Ƽ���Undefined_recommend�Զ����Ƽ�
	private String areaType;
	//����Json��ʽ
	private String content;
	//�޸�ʱ��
	private Date gmtCreate;
	//
	private Date gmtModify;
	
	private String key;
	private Object value;
	private Map<String, Object> contentMap = new HashMap<String, Object>();

	public ShopDecorateContent() {}

	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**����װ��ID*/
	public void setDecorateId(Long decorateId) {
		this.decorateId = decorateId;
	}
	/**��ȡװ��ID*/
	public Long getDecorateId() {
		return this.decorateId;
	}
	
	/**����ҳ������:index��detail*/
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	/**��ȡҳ������:index��detail*/
	public String getPageType() {
		return this.pageType;
	}
	
	/**�����������ͣ�Title���У�Guide������Bannerͨ����Seller_recommend�ƹ��Ƽ���Undefined_recommend�Զ����Ƽ�*/
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	/**��ȡ�������ͣ�Title���У�Guide������Bannerͨ����Seller_recommend�ƹ��Ƽ���Undefined_recommend�Զ����Ƽ�*/
	public String getAreaType() {
		return this.areaType;
	}
	
	/**��������Json��ʽ
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * */
	@SuppressWarnings("unchecked")
	public void setContent(String content) {
		this.content = content;
		if(this.content == null) {
			return;
		}
		ObjectMapper mapper = new ObjectMapper();  
		try {
			this.contentMap = mapper.readValue(content, HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(this.contentMap == null) {
				this.contentMap = new HashMap<String, Object>();
			}
		}
	}
	
	/**��ȡ����Json��ʽ*/
	public String getContent() {
		return this.content;
	}
	
	public Map<String, Object> getContentMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(this.contentMap);
		Map<String, Object> mapJson = new HashMap<String, Object>();
		if(!CollectionUtils.isEmpty(map)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				try {
					if(entry.getValue() instanceof List) {
						mapJson.put(entry.getKey() + "json", JSONArray.fromObject(entry.getValue()).toString());
					} else {
						mapJson.put(entry.getKey() + "json", JSONObject.fromObject(entry.getValue()).toString());
					}
				} catch (Exception e) {
				}
			}
			map.putAll(mapJson);
		}
		return map;
	}
	
	public void setContentMap(Map<String, Object> contentMap) {
		this.contentMap = contentMap;
		JSONObject object = JSONObject.fromObject(contentMap);
		this.content = object.toString();
	}

	public void addContent(String key, Object value) {
		this.contentMap.put(key, value);
		setContentMap(this.contentMap);
	}
	/**�����޸�ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ�޸�ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**����*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) throws UnsupportedEncodingException {
		String valueStr = URLDecoder.decode(String.valueOf(value), "UTF-8");
		ObjectMapper mapper = new ObjectMapper();  
		try {
			this.value = mapper.readValue(valueStr, Object.class);
		} catch (IOException e) {
			this.value = valueStr;
		}
	}
	
}