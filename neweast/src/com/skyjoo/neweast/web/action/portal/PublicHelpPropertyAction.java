/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.web.action.portal;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicHelpStatusType;
import com.skyjoo.neweast.biz.portal.service.PublicHelpCategoryService;
import com.skyjoo.neweast.biz.portal.service.PublicHelpPropertyService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 *帮助内容管理页面 
 *@author liupc
 *@version 1.0
 *@date 2014-11-5 上午8:57:32
 */
@Controller
public class PublicHelpPropertyAction extends BaseAction{
	
	@Autowired
	private PublicHelpPropertyService publicHelpPropertyService;
	
	@Autowired
	private PublicHelpCategoryService publicHelpCategoryService;
	/**
	 * 初始化类目列表
	 * @param model
	 */
	private void referenceData(Model model){
		model.addAttribute("list_cats",publicHelpCategoryService.
				getPublicHelpCategorySelNames());
	}
	
	/**
	 * 帮助内容列表
	 * @param publicHelpProperty
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/list.htm")
	public String list(PublicHelpProperty publicHelpProperty, Model model,
			HttpServletRequest request) {
		referenceData(model);
	    model.addAttribute("page", publicHelpProperty);
	    Long catId = 0L;
		try {
			catId = Long.parseLong(request.getParameter("catId"));
			publicHelpProperty.setCategoryId(catId);
		} catch (NumberFormatException e) {
		}
		publicHelpProperty = (PublicHelpProperty) publicHelpPropertyService.getPaginatedPublicHelpProperty(publicHelpProperty);
		model.addAttribute("page", publicHelpProperty);
		return "help/property/list";
	}
	
	/**
	 * 逻辑删除帮助内容
	 * @param publicHelpPropertyId
	 * @param userAgent
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/remove.htm")
	public String remove(@RequestParam("id")Long publicHelpPropertyId,
			SystemUserAgent userAgent,Model model){
		String url = "/portal/helpproperty/list.htm";
		if(publicHelpPropertyId!=null){
			PublicHelpProperty publicHelpProperty = new PublicHelpProperty();
			publicHelpProperty.setOperator(userAgent.getLoginName());
			publicHelpProperty.setId(publicHelpPropertyId);
			publicHelpProperty.setStatus(EnumPublicHelpStatusType.DELETE);
			Integer i = publicHelpPropertyService.updateStatus(publicHelpProperty);
			return i!=null?success(model,url,"删除成功"):error(model,url,"删除失败");
		}else{
			return error(model,url,"未提取到删除对象");
		}
	}
	
	/**
	 * 添加初始化
	 * @param prop
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/add-init.htm")
	public String addInit(@ModelAttribute("prop") PublicHelpProperty prop, Model model){
		referenceData(model);
		return "help/property/add";
	}
	
	/**
	 * 添加帮助内容
	 * @param prop
	 * @param result
	 * @param model
	 * @param userAgent
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/add.htm")
	public String add(@ModelAttribute("prop") PublicHelpProperty prop,
			BindingResult result, Model model,SystemUserAgent userAgent) {
		prop.setOperator(userAgent.getLoginName());
		Long id = publicHelpPropertyService.addPublicHelpProperty(prop);
		String url = "/portal/helpproperty/list.htm?catId="+prop.getCategoryId();
	    return id!=null?success(model,url,"添加成功"):error(model,url,"添加失败");
	}
	
	/**
	 * 编辑修改初始化
	 * @param publicHelpPropertyId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/edit-init.htm")
	public String editInit(@RequestParam("id")Long publicHelpPropertyId, Model model){
		referenceData(model);
		PublicHelpProperty prop = publicHelpPropertyService.getPublicHelpProperty(publicHelpPropertyId);
		model.addAttribute("prop",prop);
		String url = "/portal/helpproperty/remove.htm";
		return prop!=null?"help/property/edit":error(model,url,"获取修改对象失败");
	}
	
	/**
	 * 编辑修改
	 * @param prop
	 * @param result
	 * @param model
	 * @param userAgent
	 * @return
	 */
	@RequestMapping(value = "portal/helpproperty/edit.htm")
	public String edit(@ModelAttribute("prop") PublicHelpProperty prop, 
			BindingResult result, Model model,SystemUserAgent userAgent) {
		prop.setOperator(userAgent.getLoginName());
		Integer re = publicHelpPropertyService.updatePublicHelpProperty(prop);
	    String url = "/portal/helpproperty/list.htm?catId="+prop.getCategoryId();
	    return re!=null?success(model,url,"修改成功"):error(model,url,"修改失败");
	}
	
	/**
	 * 类目级别Ajax验证
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "portal/helpproperty/checkcat.htm")
	public void check(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Long catId = Long.parseLong(request.getParameter("categoryId").trim());
		int level = publicHelpCategoryService.getCatLevel(catId);
		response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html");
		if(level == 3){
			response.getWriter().write("true");
		}else{
			response.getWriter().write("false");
		}
		response.getWriter().flush();
	}
}
