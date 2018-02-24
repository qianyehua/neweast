package com.skyjoo.neweast.biz.common.util;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.velocity.tools.view.context.ViewContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.skyjoo.neweast.biz.common.enums.EnumCountry;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.datadic.service.ProvinceCityService;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopBizHourType;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;
import com.skyjoo.wudadao.common.enums.mall.trade.EnumExpressType;

/**
 * 枚举显示工具
 * @author lxh
 *
 */
public class EnumUtils {
	
	private ProvinceCityService provinceCityService;
	private CommDatadicCacheService commDatadicCacheService;
	
	public void init(Object obj) {
		ServletContext context = null;
        if (obj instanceof ViewContext) {
            ViewContext ctx = (ViewContext)obj;
            context = ctx.getServletContext();
        } else if(obj instanceof ServletContext) {
        	context = (ServletContext) obj;
        }
        
        if(context != null) {
        	WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        	provinceCityService = applicationContext.getBean(ProvinceCityService.class);
        	commDatadicCacheService = applicationContext.getBean(CommDatadicCacheService.class);
        }
    }
	public String getCountry(String value) {
		EnumCountry country = EnumCountry.getByValue(value);
		if(country == null) return "";
		return country.getDesp();
    }
	
	public String getCommDatadic(String groupName, String value) {
		List<CommDatadic> commDatadics = commDatadicCacheService.getCommDatadicsByGroupName(groupName);
		if(CollectionUtils.isNotEmpty(commDatadics)) {
			for (CommDatadic commDatadic : commDatadics) {
				if(commDatadic.getValue().equals(value)) {
					return commDatadic.getName();
				}
			}
		}
		return "";
	}
	
	public String getUserAccountStatus(Integer value) {
		EnumUserAccountStatus status = EnumUserAccountStatus.getByValue(value);
		if(status == null) return "";
		return status.getDesp();
    }
	
	public String getShopAuthType(Integer value) {
		EnumShopAuthType type = EnumShopAuthType.getByValue(value);
		if(type == null) return "";
		return type.getDesp();
	}
    
	public String getShopAuthStatus(Integer value) {
		EnumShopAuthStatus status = EnumShopAuthStatus.getByValue(value);
		if(status == null) return "";
		return status.getDesp();
	}
	
	public String getShopStatus(Integer value) {
		EnumShopStatus status = EnumShopStatus.getByValue(value);
		if(status == null) return "";
		return status.getDesp();
	}
	
	public String getShopBizHourType(Integer value) {
		EnumShopBizHourType type = EnumShopBizHourType.getByValue(value);
		if(type == null) return "";
		return type.getDesp();
	}
	
	public String getExpressionType(String value) {
		EnumExpressType type = EnumExpressType.getByValue(value);
		if(type == null) return "";
		return type.getDescription();
	}
	
	public String getProvinceCityName(String province, String city, String... suffix) {
    	return provinceCityService.getProvinceCityName(province, city, suffix);
    }
}
