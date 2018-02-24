package com.skyjoo.neweast.web.action.homepage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendShopService;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;
import com.skyjoo.neweast.biz.shop.service.ShopService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;

/**
 * 首页店铺推荐
 * @author lxh
 *
 */
@Controller
@RequestMapping("homepage/recommend/shop")
public class HomepageRecommendShopAction extends BaseAction {
	
	@Autowired
	private ShopService shopService;
	@Autowired
	private HomepageRecommendShopService homePageRecommendShopService;
	
	protected String baseVMPath = "/homepage/recommend/shop/";
    protected String getVMPage(String path) {
    	return baseVMPath.concat(path);
    }
    
    /**
     * 获取店铺推荐主页
     * @param query
     * @return
     */
    @RequestMapping(value="main.htm")
    public String main() {
    	return getVMPage("main");
    }
    
    /**
     * 获取店铺推荐列表
     * @param query
     * @return
     */
    @RequestMapping(value="list.htm")
    public String list(@ModelAttribute("query") ShopQuery query) {
    	query.setPageSize(10);
    	if(!query.isRecommend()) {
    		query.setStatus(EnumShopStatus.NORMAL.getValue());
    	}
    	shopService.getShopPage(query);
    	return getVMPage("list");
    }
    
    /**
     * 修改推荐
     * @param shopId
     * @param isRecommend
     * @return
     */
    @RequestMapping(value="chRecommend.htm")
    public @ResponseBody Map<String, Object> chRecommend(Long shopId, boolean isRecommend, SystemUserAgent agent) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(shopId == null) {
    		result.put("success", false);
    		return result;
    	}
    	
    	CommResult commResult = homePageRecommendShopService.chRecommend(shopId, isRecommend, agent.getLoginName());
    	if(commResult.isSuccess()) {
    		result.put("success", true);
    	} else {
    		result.put("success", false);
    		result.put("message", commResult.getErrorMsg());
    	}
    	
    	return result;
    }
    
}
