package com.skyjoo.neweast.web.action.art;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
@Controller
public class ArtCategoryAction extends BaseAction{
	
	@Autowired
	private ArtCategoryService artCategoryService;
	
	/**
	 * 获取艺术品一级类目
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_list.htm")
	public String categoryList(HttpServletRequest request,Model model){
		List<ArtCategory> list = artCategoryService.getFirstCategoryList();
		model.addAttribute("list_category", list);
		return "art/artCategory/artCategory_list";
	}
	
	/**
	 * 通过父id获取子类目
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory2_list.htm")
	public String categoryListByParid(HttpServletRequest request,Model model){
		String param = request.getParameter("pid");
		Long pid = null;
		if(param != null && !"".equals(param)){
			pid = Long.parseLong(param);
		}
		List<ArtCategory> list = artCategoryService.getCategoryListByParid(pid);
		model.addAttribute("list_category",list);
		model.addAttribute("pid",pid);	
		return "art/artCategory/artCategory2_list";
	}
	
	/**
	 * 初始化类目添加
	 * @param artCategory
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_addIni.htm")
	public String addIni(@ModelAttribute("category")ArtCategory artCategory,HttpServletRequest request,Model model){
		String param = request.getParameter("pid");
		Long pid = null;
		if(param != null && !"".equals(param)){
			pid = Long.parseLong(param);
		}
		if(pid != null){
			model.addAttribute("pid", pid);
		}
		return "art/artCategory/artCategory_add";
	}
	
	/**
	 * 添加类目  
	 * @param artCategory
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_add.htm")
	public String addCategory(SystemUserAgent agent, HttpServletRequest request,@ModelAttribute("category")ArtCategory artCategory,BindingResult result,Model model){
		Long pid = Long.parseLong(request.getParameter("pid"));
		String url = "";
		if(pid.compareTo(0L) != 0){
			url = "/art/artCategory/artCategory2_list.htm?pid="+pid;
		}
		else{
			url = "/art/artCategory/artCategory_list.htm";
		}
		artCategory.setParentId(pid);
		artCategory.setOperator(agent.getLoginName());	
		Long addResult = artCategoryService.addArtFirstCategory(artCategory);	
		return addResult.compareTo(0L) != 0 ?success(model,url,"添加成功") : error(model,url,"添加失败");
	}
	
	/**
	 * 初始化类目修改,获取必要数据
	 * @param request
	 * @param artCategory
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_editIni.htm")
	public String editArtCategoryIni(HttpServletRequest request,@ModelAttribute("category")ArtCategory artCategory,Model model){
		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		Long parentId = Long.parseLong(request.getParameter("pid"));
		ArtCategory category = artCategoryService.getCategoryListbyId(categoryId);
		model.addAttribute("category",category);
		model.addAttribute("parentId", parentId);
		return "art/artCategory/artCategory_edit";
	}
	
	/**
	 * 类目修改
	 * @param request
	 * @param artCategory
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_edit.htm")
	public String editArtCategory(HttpServletRequest request,@ModelAttribute("category")ArtCategory artCategory,Model model){
		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		Long parentId = Long.parseLong(request.getParameter("parentId"));
		String url = "";
		if(parentId.compareTo(0L) == 0){
			url = "/art/artCategory/artCategory_list.htm";
		}
		else{
			url = "/art/artCategory/artCategory2_list.htm?pid="+parentId;
		}
		artCategory.setId(categoryId);
		int editResult = artCategoryService.editArtCategory(artCategory);
		return editResult == 0 ? error(model,url,"修改失败") : success(model,url,"修改成功");
	}
	
	/**
	 * 获取艺术品编号（前缀)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCode_list.htm")
	public String artCodeList(HttpServletRequest request,Model model){
		ArtCategory category = artCategoryService.getCategoryListbyId(Long.parseLong(request.getParameter("categoryId")));
		model.addAttribute("category",category);
		return "art/artCategory/artCode_list";
	}
	
	/**
	 * 初始化编号修改
	 * @param request
	 * @param artCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCode_editIni.htm")
	public String editArtCodeIni(HttpServletRequest request,@ModelAttribute("category") ArtCategory category,Model model){
		model.addAttribute("categoryId",request.getParameter("categoryId"));
		model.addAttribute("artCode",request.getParameter("artCode"));	
		return "art/artCategory/artCode_edit";
	}
	
	/**
	 * 艺术品编号修改
	 * @param request
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCode_edit.htm")
	public String editArtCode(HttpServletRequest request,@ModelAttribute("category") ArtCategory category,Model model){
		category.setId(Long.parseLong(request.getParameter("categoryId")));	
		int editResult = artCategoryService.editArtCode(category);
		return editResult == 0 ? "error" : success(model,"/art/artCategory/artCategory2_list.htm?pid="
		+artCategoryService.getCategoryListbyId(category.getId()).getParentId(),"修改成功");
	}
	
	/**
	 * 删除指定的类目
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/artCategory/artCategory_remove.htm")
	public String removeArtCategory(HttpServletRequest request,Model model){
		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		int removeResult = artCategoryService.removeArtCategory(categoryId);
		return removeResult == 0 ? "error":"success";
	}
	
	/**
	 * jQuery ajax验证类目名的唯一性
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkCategoryName.htm")
	public void checkCategoryName(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String categoryName = request.getParameter("categoryName");
		String categoryId = request.getParameter("categoryId");
		String parentId = request.getParameter("parentId");
		if(categoryName == null || "".equals(categoryName)){
			return ;
		}
		List<ArtCategory> categories = artCategoryService.getCategoryList();
		for(ArtCategory category : categories){
			if(categoryName.equals(category.getName()) && (parentId.equals(category.getParentId()+"")) && !((category.getId()+"").equals(categoryId))){
				response.getWriter().write("该类目名已经存在");
				return;
			}
		} 
		response.getWriter().write("该类目名可以使用");
	}
	
	/**
	 * jQuery ajax验证前缀唯一性
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkArtCode.htm")
	public void checkArtCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String artCode = request.getParameter("artCode").toUpperCase();	
		String categoryId = request.getParameter("categoryId");
		List<ArtCategory> categories = artCategoryService.getCategoryList();
		for(ArtCategory category : categories){
			if(artCode.equals(category.getArtCode()) && !((category.getId()+"").equals(categoryId))){
				response.getWriter().write("该前缀已经存在");
				return ;
			}
		}
		response.getWriter().write("该前缀可以使用");
	}

}
