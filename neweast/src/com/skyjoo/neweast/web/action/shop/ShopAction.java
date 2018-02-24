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
	 * �����б�
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
	 * ��������
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="detail.htm")
	public String detail(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "��ЧID");
			return "error";
		}
		
		model.put("shop", shop);
		return getReturnPage("detail");
	}
	
	/**
	 * ����ҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="switch.htm", method=RequestMethod.GET)
	public String switchInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "��ЧID");
			return "error";
		}
		
		if(shop.isClosed()) {
			model.put("message", "�����ѹر�");
			return "error";
		}
		
		model.put("shop", shop);
		model.put("switchList", EnumSwitch.values());
		return getReturnPage("switch");
	}
	
	/**
	 * �����޸�
	 * @param shop
	 * @param model
	 * @return
	 */
	@RequestMapping(value="switch.htm", method=RequestMethod.POST)
	public String doSwitch(@ModelAttribute("shop") Shop shop, ModelMap model) {
		if(shop.getId() == null) {
			model.put("message", "��ЧID");
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
	 * �رյ���
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="close.htm", method=RequestMethod.GET)
	public String closeInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "���̲�����");
			return "error";
		}
		
		if(!shop.isNormal()) {
			model.put("message", "�õ��̲��ܽ��йرղ���");
			return "error";
		}
		model.put("shop", shop);
		return getReturnPage("close");
	}
	
	/**
	 * �رյ���
	 * @param shop
	 * @param model
	 * @return
	 */
	@RequestMapping(value="close.htm", method=RequestMethod.POST)
	public String close(@ModelAttribute("shop") Shop shop, ModelMap model) {
		
		CommResult result = shopService.closeShop(shop);
		
		model.put("url", "/shop/list.htm");
		if(result.isSuccess()) {
			model.put("message", "���̹رճɹ�");
			return "success";
		} else {
			model.put("message", "���̹ر�ʧ�ܡ�" + result.getErrorMsg());
			return "error";
		}
	}
	
	/**
	 * �ָ�����
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="resume.htm", method=RequestMethod.GET)
	public String resumeInit(Long id, ModelMap model) {
		Shop shop = shopService.getShopById(id);
		if(shop == null) {
			model.put("message", "���̲�����");
			return "error";
		}
		
		if(!shop.isClosed()) {
			model.put("message", "�õ��̲��ܽ��лָ�����");
			return "error";
		}
		
		model.put("shop", shop);
		return getReturnPage("resume");
	}
	
	/**
	 * �ָ�����
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="resume.htm", method=RequestMethod.POST)
	public String resume(@ModelAttribute("shop") Shop shop, ModelMap model) {
		
		CommResult result = shopService.resumeShop(shop);
		
		model.put("url", "/shop/list.htm");
		if(result.isSuccess()) {
			model.put("message", "���ָ̻��ɹ�");
			return "success";
		} else {
			model.put("message", "���ָ̻�ʧ�ܡ�" + result.getErrorMsg());
			return "error";
		}
	}
	
	
}
