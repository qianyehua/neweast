package com.skyjoo.neweast.web.action.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;
import com.skyjoo.neweast.biz.shop.service.ShopAuthApplyService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;

/**
 * 店铺认证审核
 * @author lxh
 *
 */
@Controller
@RequestMapping("shop/apply/")
public class ShopAuthApplyAction extends BaseAction {
	
	@Autowired
	private ShopAuthApplyService shopAuthApplyService;
	@Autowired
	private CommDatadicCacheService commDatadicCacheService;
	
	private static final String baseVMPath = "shop/apply/";
	private String getReturnPage(String page) {
		return baseVMPath.concat(page);
	}
	
	private void referData(ModelMap model, boolean isPersonal) {
		if(isPersonal) {
			model.addAttribute("licenseTypeList", commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.LICENSE_TYPE));
			model.addAttribute("majorTypeList", commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.MAJOR_TYPE));
		}
	}
	
	/**
	 * 审核列表
	 * @param query
	 * @return
	 */
	@RequestMapping("list.htm")
	public String list(@ModelAttribute("query") ShopAuthApplyQuery query, ModelMap model) {
		shopAuthApplyService.getShopAuthApplyPage(query);
		model.put("typeList", EnumShopAuthType.values());
		model.put("statusList", EnumShopAuthStatus.values());
		return getReturnPage("list");
	}
	
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("detail.htm")
	public String detail(Long id, ModelMap model) {
		ShopAuthApply apply = shopAuthApplyService.getShopAuthApplyById(id);
		if(apply == null) {
			model.put("message", "无效参数");
			return "error";
		}
		
		referData(model, apply.isPersonal());
		model.put("apply", apply);
		return getReturnPage("detail");
	}
	
	/**
	 * 审核页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="audit.htm", method=RequestMethod.GET)
	public String auditInit(Long id, ModelMap model) {
		ShopAuthApply apply = shopAuthApplyService.getShopAuthApplyById(id);
		if(apply == null) {
			model.put("url", "/shop/apply/list.htm");
			model.put("message", "无效参数");
			return "error";
		}
		
		if(!apply.isAuditing()) {
			model.put("url", "/shop/apply/list.htm");
			model.put("message", "无需审核");
			return "error";
		}
		
		referData(model, apply.isPersonal());
		model.put("apply", apply);
		return getReturnPage("audit");
	}
	
	/**
	 * 审核提交
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="audit.htm", method=RequestMethod.POST)
	public String audit(@ModelAttribute("apply") ShopAuthApply apply, boolean success, SystemUserAgent agent, ModelMap model) {
		CommResult result = shopAuthApplyService.auditShopAuthApply(apply, success, agent.getLoginName());
		model.put("url", "/shop/apply/list.htm");
		if(result.isSuccess()) {
			return "success";
		} else {
			return "error";
		}
	}
}
