package com.skyjoo.neweast.web.action.homepage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.art.enums.EnumArtType;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.common.service.CacheService;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.art.EnumArtStatus;

/**
 * 首页艺术品推荐
 * @author lxh
 *
 */
@Controller
@RequestMapping("homepage/recommend/art")
public class HomepageRecommendAction extends BaseAction {
	
	@Autowired
	private ArtService artService;
	@Autowired
	private ArtCategoryService artCategoryService;
	@Autowired
	private HomepageRecommendService homepageRecommendService;
	@Autowired
	private CacheService cacheService;
	
	protected String baseVMPath = "/homepage/recommend/art/";
    protected String getVMPage(String path) {
    	return baseVMPath.concat(path);
    }
    
    /**
     * 获取艺术品推荐主页
     * @param query
     * @return
     */
    @RequestMapping(value="main.htm")
    public String main() {
    	return getVMPage("main");
    }
    
    /**
     * 获取艺术品推荐列表
     * @param query
     * @return
     */
    @RequestMapping(value="list.htm")
    public String list(@ModelAttribute("query") ArtCheckQuery query, ModelMap model) {
    	query.setPageSize(10);
    	if(query.isRecommend()) {
    		model.addAttribute("list_menus", artCategoryService.getFirstCategoryList());
    	} else {
    		Long categoryId = query.getCategoryId();
    		if(categoryId != null){
    			ArtCategory artCategory = artCategoryService.getCategoryListbyId(categoryId);
    			if(artCategory.getParentId() == 0){
    				query.setArtParentCategoryId(categoryId);
    				query.setCategoryId(null);
    			}
    		}
    		query.setStatus(EnumArtStatus.NORMAL.getValue());
    		model.addAttribute("list_menus", cacheService.getArtCategoryNames());
    	}
    	query.setIsArtiseWork(true);
    	if(query.isRecommend()){
    	    artService.getPaginatedHomeRecommendArt(query);
    	}else{
    	    artService.getPaginatedAllArt(query);
    	}
    	model.addAttribute("artTypeList",  EnumArtType.values());
    	return getVMPage("list");
    }
    
    /**
     * 修改推荐
     * @param artId
     * @param isRecommend
     * @return
     */
    @RequestMapping(value="chRecommend.htm")
    public @ResponseBody Map<String, Object> chRecommend(Long artId, boolean isRecommend, SystemUserAgent agent) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(artId == null) {
    		result.put("success", false);
    		return result;
    	}
    	
    	CommResult commResult = homepageRecommendService.chRecommend(artId, isRecommend, agent.getLoginName());
    	if(commResult.isSuccess()) {
    		result.put("success", true);
    	} else {
    		result.put("success", false);
    		result.put("message", commResult.getErrorMsg());
    	}
    	return result;
    }
    
}
