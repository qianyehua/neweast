package com.skyjoo.neweast.web.action.art;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtPropertyOptionService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

@Controller
public class ArtPropertyOptionAction extends BaseAction {

	@Autowired
	private ArtPropertyOptionService artPropertyOptionService;

	@Autowired
	private ArtCategoryPropertyService artCategoryPropertyService;

	/**
	 * 获取艺术品属性列表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/list.htm")
	public String getListByProId(HttpServletRequest request, Model model) {
		String cid = request.getParameter("categoryId");
		Long categoryId = StringUtils.isBlank(cid)?-1:Long.valueOf(cid);
		Long propertyId = Long.parseLong(request.getParameter("propertyId"));
		
		List<ArtPropertyOption> list = artPropertyOptionService
				.getPropertyOptionByProId(propertyId,categoryId);
		model.addAttribute("list_option", list);
		model.addAttribute("propertyId", propertyId);
		model.addAttribute("categoryId", request.getParameter("categoryId"));
		model.addAttribute("parentId", request.getParameter("parentId"));
		return "art/artPropertyOption/list";
	}

	/**
	 * 初始化选项修改
	 * 
	 * @param request
	 * @param option
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/editIni.htm")
	public String editIni(HttpServletRequest request,
			@ModelAttribute("option") ArtPropertyOption option, Model model) {
		ArtPropertyOption artPropertyOption = artPropertyOptionService
				.getPropertyOptyById(Long.parseLong(request
						.getParameter("optionId")));
		model.addAttribute("option", artPropertyOption);
		model.addAttribute("propertyId", request.getParameter("propertyId"));
		model.addAttribute("categoryId", request.getParameter("categoryId"));
		model.addAttribute("parentId", request.getParameter("parentId"));
		return "art/artPropertyOption/edit";
	}

	/**
	 * 选项修改
	 * 
	 * @param request
	 * @param option
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/edit.htm")
	public String edit(SystemUserAgent agent, HttpServletRequest request,
			@ModelAttribute("option") ArtPropertyOption option, Model model) {
		Long optionId = Long.parseLong(request.getParameter("optionId"));
		String categoryId = request.getParameter("categoryId");
		String parentId = request.getParameter("parentId");
		Long propertyId = Long.parseLong(request.getParameter("propertyId"));
		String url = "/art/artPropertyOption/list.htm?propertyId="
				+ request.getParameter("propertyId") + "&categoryId="
				+ categoryId + "&parentId=" + parentId;
		option.setId(optionId);
		option.setOperator(agent.getLoginName());
		option.setPropertyId(propertyId);
		Long cid = StringUtils.isBlank(categoryId)?-1:Long.valueOf(categoryId);
		List<ArtPropertyOption> options = artPropertyOptionService
				.getPropertyOptionByProId(propertyId,cid);
		ArtPropertyOption apo = artPropertyOptionService.getPropertyOptyById(optionId);
		if (apo.getContent().equals(option.getContent())) {
			long editResult = artPropertyOptionService.updatePropertyOption(option);
			return editResult == 0 ? error(model, url, "修改失败") : success(model,
					url, "修改成功");
		}
		for (ArtPropertyOption option1 : options) {
			if (option.getContent().trim().equals(option1.getContent().trim())
					&& (optionId.longValue()!=option1.getId().longValue())) {
				return error(model, url, "修改失败，该选项已存在");
			}
		}
		option.setCategoryId(cid);
		long editResult = artPropertyOptionService.editPropertyOption(option);
		return editResult == 0 ? error(model, url, "修改失败") : success(model,
				url, "修改成功");
	}

	/**
	 * 初始化增加
	 * 
	 * @param request
	 * @param option
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/addIni.htm")
	public String addIni(HttpServletRequest request,
			@ModelAttribute("option") ArtPropertyOption option, Model model) {
		model.addAttribute("propertyId", request.getParameter("propertyId"));
		model.addAttribute("categoryId", request.getParameter("categoryId"));
		model.addAttribute("parentId", request.getParameter("parentId"));
		return "art/artPropertyOption/add";
	}

	/**
	 * 添加属性选项
	 * 
	 * @param request
	 * @param option
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/add.htm")
	public String add(SystemUserAgent agent, HttpServletRequest request,
			@ModelAttribute("option") ArtPropertyOption option, Model model) {
		Long propertyId = Long.parseLong(request.getParameter("propertyId"));
		String cId = request.getParameter("categoryId").trim();
		String pId = request.getParameter("parentId").trim();
		String url = "/art/artPropertyOption/list.htm?propertyId=" + propertyId
				+ "&categoryId=" + cId + "&parentId=" + pId;
		// ArtCategoryProperty property = artCategoryPropertyService
		// .getCategoryPropertyById(propertyId);
		// if (StringUtils.isNotBlank(cId)) {
		// option.setCategoryId(Long.valueOf(cId));
		// }
		// option.setOptionType(property.getPropertyType());
		option.setPropertyId(propertyId);
		option.setOperator(agent.getLoginName());
		Long categoryId = StringUtils.isBlank(cId)?-1:Long.valueOf(cId);
		option.setCategoryId(categoryId);
		List<ArtPropertyOption> options = artPropertyOptionService
				.getPropertyOptionByProId(propertyId,categoryId);
		for (ArtPropertyOption option1 : options) {
			if (option.getContent().equals(option1.getContent().trim())) {
				return error(model, url, "添加失败，该选项已存在");
			}
		}
		Long addResult = artPropertyOptionService.addPropertyOption(option);
		return addResult != 0 ? success(model, url, "添加成功") : error(model, url,
				"添加失败");
	}

	/**
	 * 删除选项
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artPropertyOption/remove.htm")
	public String removePropertyOption(HttpServletRequest request, Model model) {
		String propertyId = request.getParameter("propertyId");
		String categoryId = request.getParameter("categoryId");
		String parentId = request.getParameter("parentId");
		String optionId = request.getParameter("optionId");
		long removeResult = artPropertyOptionService.removePropertyOption(
				Long.parseLong(optionId), Long.parseLong(propertyId),StringUtils.isBlank(categoryId)?-1:Long.parseLong(categoryId));
		String url = "/art/artPropertyOption/list.htm?propertyId=" + propertyId
				+ "&categoryId=" + categoryId + "&parentId=" + parentId;
		return removeResult == 0 ? error(model, url, "删除失败,有艺术品正在使用该属性")
				: success(model, url, "删除成功");
	}

	/**
	 * 验证属性的唯一性
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkOptionContent.htm")
	public void checkOptionContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Long propertyId = Long.parseLong(request.getParameter("propertyId"));
		Long optionId = Long.parseLong(request.getParameter("optionId"));
		String categoryId = request.getParameter("categoryId");
		String content = request.getParameter("content").trim();
		Long cid = StringUtils.isBlank(categoryId)?-1:Long.valueOf(categoryId);
		List<ArtPropertyOption> options = artPropertyOptionService
				.getPropertyOptionByProId(propertyId,cid);
		for (ArtPropertyOption option : options) {
			if (content.equals(option.getContent())
					&& optionId.compareTo(option.getId()) != 0) {
				response.getWriter().write("该选项已经存在");
				return;
			}
		}
		response.getWriter().write("该选项可以使用");
	}
}
