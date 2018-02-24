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
 * ����������Ŀ����ҳ��
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 ����10:15:29
 */
@Controller
public class PublicHelpCategoryAction extends BaseAction {

	@Autowired
	private PublicHelpCategoryService publicHelpCategoryService;
	
	/**
	 * ����������Ŀ�б�--��ʼΪһ����Ŀ
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
			//�������
		}
		List<PublicHelpCategory> list = publicHelpCategoryService
				.getPublicHelpCategoryByPid(pid);
		model.addAttribute("list_cat", list);
		model.addAttribute("pid", pid);
		return "help/category/list";
	}
	 /**
	  * ɾ��һ����Ŀ--�߼�ɾ��
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
	    return i!=null?success(model,url,"ɾ���ɹ�"):error(model,url,"ɾ��ʧ��");
	 }
	 
	 /**
	  * �����Ŀ��ʼҳ��
	  * @param cat
	  * @param model
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/add-init.htm")
	 public String addInit(@ModelAttribute("cat") PublicHelpCategory cat, Model model) {
		 return "help/category/add";
	 }
	 /**
	  * �����Ŀ
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
		 return id!=null?success(model,url,"��ӳɹ�"):error(model,url,"���ʧ��");
	 }
	 
	 /**
	  * �޸���Ŀ��ʼҳ��
	  * @param id
	  * @param model
	  * @return
	  */
	 @RequestMapping("/portal/helpcategory/edit-init.htm")
	 public String editInit(@RequestParam("id")Long id, Model model) {
		 PublicHelpCategory cat = publicHelpCategoryService.getPublicHelpCategoryById(id);
		 model.addAttribute("cat",cat);
		 String url = "/portal/helpcategory/list.htm";
		 return cat!=null?"help/category/edit":error(model,url,"��ȡ�޸Ķ���ʧ��");
	 }
	
	 /**
	  * �޸���Ŀ
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
	     return i!=null?success(model,url,"�޸ĳɹ�"):error(model,url,"�޸�ʧ��");
	 }
	 
	 /**
	  * ���ذ�ť
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
			//�������
		}
		pid = publicHelpCategoryService.getPublicHelpCategoryById(id).getParentId();
		List<PublicHelpCategory> list = publicHelpCategoryService
				.getPublicHelpCategoryByPid(pid);
		model.addAttribute("list_cat", list);
		model.addAttribute("pid", pid);
		return "help/category/list";
	 }
	 
	 /**
	  *  ��Ŀ����Ajax��֤
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
