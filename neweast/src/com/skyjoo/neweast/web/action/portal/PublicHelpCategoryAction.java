/**
 *@title
 *@author liupc
 *@version 1.0
 */
package com.skyjoo.neweast.web.action.portal;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicHelpStatusType;
import com.skyjoo.neweast.biz.portal.service.PublicHelpCategoryService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 * 帮助中心类目管理页面
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 上午10:15:29
 */
@Controller
public class PublicHelpCategoryAction extends BaseAction {

	@Autowired
	private PublicHelpCategoryService publicHelpCategoryService;
	
	/**
	 * 帮助中心类目列表--初始为一级类目
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/portal/helpcategory/list.htm")
	public String list(HttpServletRequest request, Model model) {
		Long pid = 0L;
		try {
			pid = Long.parseLong(request.getParameter("pid"));
		} catch (NumberFormatException e) {
			//无需操作
		}
		List<PublicHelpCategory> list = publicHelpCategoryService
				.getPublicHelpCategoryByPid(pid);
		model.addAttribute("list_cat", list);
		model.addAttribute("pid", pid);
		return "help/category/list";
	}
	 /**
	  * 删除一条类目--逻辑删除
	  * @param id
	  * @param pid
	  * @param model
	  * @param userAgent
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/remove.htm")
	 public String remove(@RequestParam("id")Long id,@RequestParam("pid")Long 
			 pid, Model model,SystemUserAgent userAgent) {
		PublicHelpCategory publicHelpCategory = new PublicHelpCategory();
		publicHelpCategory.setId(id);
		publicHelpCategory.setIsDeleted(EnumPublicHelpStatusType.DELETE);
		publicHelpCategory.setOperator(userAgent.getLoginName());
	    Integer i = publicHelpCategoryService.removePublicHelpCategory(publicHelpCategory);
	    String url = "/portal/helpcategory/list.htm?pid="+pid;
	    return i!=null?success(model,url,"删除成功"):error(model,url,"删除失败");
	 }
	 
	 /**
	  * 添加类目初始页面
	  * @param cat
	  * @param model
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/add-init.htm")
	 public String addInit(@ModelAttribute("cat") PublicHelpCategory cat, Model model) {
		 return "help/category/add";
	 }
	 /**
	  * 添加类目
	  * @param cat
	  * @param result
	  * @param model
	  * @param userAgent
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/add.htm")
	 public String add(@ModelAttribute("cat") PublicHelpCategory cat, 
			 BindingResult result, Model model,SystemUserAgent userAgent) {
		 cat.setOperator(userAgent.getLoginName());
		 Long id = publicHelpCategoryService.addPublicHelpCategory(cat);
		 String url = "/portal/helpcategory/list.htm?pid="+cat.getParentId();
		 return id!=null?success(model,url,"添加成功"):error(model,url,"添加失败");
	 }
	 
	 /**
	  * 修改类目初始页面
	  * @param id
	  * @param model
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/edit-init.htm")
	 public String editInit(@RequestParam("id")Long id, Model model) {
		 PublicHelpCategory cat = publicHelpCategoryService.getPublicHelpCategoryById(id);
		 model.addAttribute("cat",cat);
		 String url = "/portal/helpcategory/list.htm";
		 return cat!=null?"help/category/edit":error(model,url,"获取修改对象失败");
	 }
	
	 /**
	  * 修改类目
	  * @param cat
	  * @param result
	  * @param model
	  * @param userAgent
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/edit.htm")
	 public String edit(@ModelAttribute("cat") PublicHelpCategory cat, 
			 BindingResult result, Model model,SystemUserAgent userAgent) {
		 cat.setOperator(userAgent.getLoginName());
		 Integer i = publicHelpCategoryService.editPublicHelpCategory(cat);
		 String url = "/portal/helpcategory/list.htm?pid="+cat.getParentId();
	     return i!=null?success(model,url,"修改成功"):error(model,url,"修改失败");
	 }
	 
	 /**
	  * 返回按钮
	  * @param request
	  * @param model
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/back.htm")
	 public String back(HttpServletRequest request, Model model){
		Long id = 0L;
		Long pid = 0L;
		try {
			id = Long.parseLong(request.getParameter("pid"));
		} catch (NumberFormatException e) {
			//无需操作
		}
		pid = publicHelpCategoryService.getPublicHelpCategoryById(id).getParentId();
		List<PublicHelpCategory> list = publicHelpCategoryService
				.getPublicHelpCategoryByPid(pid);
		model.addAttribute("list_cat", list);
		model.addAttribute("pid", pid);
		return "help/category/list";
	 }
	 
	 /**
	  *  类目名称Ajax验证
	  * @param request
	  * @param response
	  * @throws IOException
	  */
	 @RequestMapping(value = "portal/helpcategory/checkcat.htm")
	 public void check(HttpServletRequest request, HttpServletResponse response) 
			 throws IOException{
		 Long parentId = Long.parseLong(request.getParameter("parentId").trim());
		 String name = request.getParameter("name");
		 String id = request.getParameter("id");
		 PublicHelpCategory publicHelpCategory = new PublicHelpCategory();
		 if(id!=null){
			 publicHelpCategory.setId(Long.parseLong(id));
		 }
		 publicHelpCategory.setParentId(parentId);
		 publicHelpCategory.setName(name);
		 Integer i = publicHelpCategoryService.getCategeoryByName(publicHelpCategory);
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html");
		 if(i!=null && i.compareTo(0)>0){
			 response.getWriter().write("false");
		 }else{
			 response.getWriter().write("true");
		 }
		 response.getWriter().flush();
	}
}
