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
 * 店铺装修内容表
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
	//装修ID
	private Long decorateId;
	//页面类型:index，detail
	private String pageType;
	//区域类型：Title店招，Guide导航，Banner通栏，Seller_recommend掌柜推荐，Undefined_recommend自定义推荐
	private String areaType;
	//内容Json格式
	private String content;
	//修改时间
	private Date gmtCreate;
	//
	private Date gmtModify;
	
	private String key;
	private Object value;
	private Map<String, Object> contentMap = new HashMap<String, Object>();

	public ShopDecorateContent() {}

	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置装修ID*/
	public void setDecorateId(Long decorateId) {
		this.decorateId = decorateId;
	}
	/**获取装修ID*/
	public Long getDecorateId() {
		return this.decorateId;
	}
	
	/**设置页面类型:index，detail*/
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	/**获取页面类型:index，detail*/
	public String getPageType() {
		return this.pageType;
	}
	
	/**设置区域类型：Title店招，Guide导航，Banner通栏，Seller_recommend掌柜推荐，Undefined_recommend自定义推荐*/
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	/**获取区域类型：Title店招，Guide导航，Banner通栏，Seller_recommend掌柜推荐，Undefined_recommend自定义推荐*/
	public String getAreaType() {
		return this.areaType;
	}
	
	/**设置内容Json格式
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
	
	/**获取内容Json格式*/
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
	/**设置修改时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取修改时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取*/
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