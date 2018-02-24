package com.skyjoo.neweast.web.action.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.wudadao.common.enums.EnumSwitch;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;
import com.skyjoo.neweast.biz.shop.service.ShopService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;

@Controller
@RequestMapping("shop/")
public class ShopAction extends BaseAction {
	
	@Autowired
	private ShopService shopService;
	
	private static final String baseVMPath = "shop/";
	private String getReturnPage(String page) {
		return baseVMPath.concat(page);
	}
	
	/**
	 * 店铺列表
	 * @param query
	 * @return
	 */
	@RequestMapping(value="list.htm")
	public String list(@ModelAttribute("query") ShopQuery query, ModelMap model) {
		shopService.getShopPage(query);
		model.put("statusList", EnumShopStatus.values());
		return getReturnPage("list");
	}
	
	/**
	 * 店铺详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="detail.htm")
	public String detail(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "无效ID");
			return "error";
		}
		
		model.put("shop", shop);
		return getReturnPage("detail");
	}
	
	/**
	 * 开关页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="switch.htm", method=RequestMethod.GET)
	public String switchInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "无效ID");
			return "error";
		}
		
		if(shop.isClosed()) {
			model.put("message", "店铺已关闭");
			return "error";
		}
		
		model.put("shop", shop);
		model.put("switchList", EnumSwitch.values());
		return getReturnPage("switch");
	}
	
	/**
	 * 开关修改
	 * @param shop
	 * @param model
	 * @return
	 */
	@RequestMapping(value="switch.htm", method=RequestMethod.POST)
	public String doSwitch(@ModelAttribute("shop") Shop shop, ModelMap model) {
		if(shop.getId() == null) {
			model.put("message", "无效ID");
			return "error";
		}
		
		CommResult result = shopService.changeSwtich(shop);
		model.put("url", "/shop/list.htm");
		if(result.isSuccess()) {
			return "success";
		} else {
			model.put("message", result.getErrorMsg());
			return "error";
		}
	}
	
	/**
	 * 关闭店铺
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="close.htm", method=RequestMethod.GET)
	public String closeInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "店铺不存在");
			return "error";
		}
		
		if(!shop.isNormal()) {
			model.put("message", "该店铺不能进行关闭操作");
			return "error";
		}
		model.put("shop", shop);
		return getReturnPage("close");
	}
	
	/**
	 * 关闭店铺
	 * @param shop
	 * @param model
	 * @return
	 */
	@RequestMapping(value="close.htm", method=RequestMethod.POST)
	public String close(@ModelAttribute("shop") Shop shop, ModelMap model) {
		
		CommResult result = shopService.closeShop(shop);
		
		model.put("url", "/shop/list.htm");
		if(result.isSuccess()) {
			model.put("message", "店铺关闭成功");
			return "success";
		} else {
			model.put("message", "店铺关闭失败。" + result.getErrorMsg());
			return "error";
		}
	}
	
	/**
	 * 恢复店铺
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="resume.htm", method=RequestMethod.GET)
	public String resumeInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "店铺不存在");
			return "error";
		}
		
		if(!shop.isClosed()) {
			model.put("message", "该店铺不能进行恢复操作");
			return "error";
		}
		
		model.put("shop", shop);
		return getReturnPage("resume");
	}
	
	/**
	 * 恢复店铺
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="resume.htm", method=RequestMethod.POST)
	public String resume(@ModelAttribute("shop") Shop shop, ModelMap model) {
		
		CommResult result = shopService.resumeShop(shop);
		
		model.put("url", "/shop/list.htm");
		if(result.isSuccess()) {
			model.put("message", "店铺恢复成功");
			return "success";
		} else {
			model.put("message", "店铺恢复失败。" + result.getErrorMsg());
			return "error";
		}
	}
	
	
}
