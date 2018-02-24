package com.skyjoo.neweast.biz.datadic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;
import com.skyjoo.neweast.biz.datadic.domain.SimpleCity;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.datadic.service.ProvinceCityService;

@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {

	@Autowired
	private CommDatadicCacheService commDatadicCacheService;
	
	//key：id	所有的省份
	private static Map<Long, SimpleCity> provinceMap = new HashMap<Long, SimpleCity>();
	//key：代码	所有的省份城市
	private static Map<String, SimpleCity> simpleCityMap = new HashMap<String, SimpleCity>();
	
	private static List<SimpleCity> provinceCityList = new ArrayList<SimpleCity>();
	private static List<String> directCity = new ArrayList<String>();
	
	static {
		directCity.add("北京");
		directCity.add("上海");
		directCity.add("天津");
		directCity.add("重庆");
	}
	
	@PostConstruct
	public void init() {
		provinceCityList.clear();
		for (CommDatadic province : commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.ACCOUNT_PROVINCE)) {
			SimpleCity p = new SimpleCity(province);
			simpleCityMap.put(p.getValue(), p);
			
			provinceMap.put(p.getId(), p);
            provinceCityList.add(p);
        }
		
		for (CommDatadic city : commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.ACCOUNT_CITY)) {
			SimpleCity c = new SimpleCity(city);
			simpleCityMap.put(c.getValue(), c);
			
			SimpleCity province = provinceMap.get(city.getParentId());
			if(province != null) {
				province.getCities().add(c);
			}
		}
	}

	@Override
	public List<SimpleCity> getSimpleProvinceCityList() {
		return provinceCityList;
	}

	@Override
	public String getProvinceCityName(String province, String city, String... suffix) {
		StringBuffer sb = new StringBuffer();
		SimpleCity p = simpleCityMap.get(province);
		if(p != null && !directCity.contains(p.getName())) {
			sb.append(p.getName());
			if(suffix.length >= 1) {
				sb.append(suffix[0]);
			}
			sb.append(" ");
		}
		
		SimpleCity c = simpleCityMap.get(city);
		if(c != null) {
			sb.append(c.getName());
			if(suffix.length >= 2) {
				sb.append(suffix[1]);
			}
		}
		return sb.toString();
	}

}
