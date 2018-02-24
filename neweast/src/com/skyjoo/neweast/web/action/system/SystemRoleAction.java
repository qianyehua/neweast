package com.skyjoo.neweast.web.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.system.domain.SystemRole;
import com.skyjoo.neweast.biz.system.service.SystemFunctionService;
import com.skyjoo.neweast.biz.system.service.SystemRoleService;
import com.skyjoo.neweast.biz.system.service.SystemUserRoleService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
/**
 * @author wangming
 *
 */

@Controller
public class SystemRoleAction extends BaseAction {

    @Autowired
    public  SystemRoleService systemRoleService;
    @Autowired
    public SystemFunctionService systemFunctionService;
    @Autowired
    public SystemUserRoleService systemUserRoleService;
    
    /**
     * ��ɫ�б�
     * @param page
     * @param model
     * @return
     */
	@RequestMapping("/system/role/list.htm")
    public String list(@ModelAttribute("query") Pagination<SystemRole> page, Model model){
    	Paginable<SystemRole> list = systemRoleService.getRoles(page);
    	model.addAttribute("list", list);
    	return "system/role/list";
    }
    
	/**
	 * ��ӽ�ɫ��ʼ��ҳ��
	 * @param role
	 * @param model
	 * @return
	 */
    @RequestMapping("/system/role/add-init.htm")
    public String addInit(@ModelAttribute("role") SystemRole role, Model model){
    	JSONArray data = systemRoleService.getSystemFunctionJson(null);
    	int count = systemFunctionService.getFunctionCount();
    	model.addAttribute("data", data);
    	model.addAttribute("count", count);
    	return "system/role/add";
    }
    
    /**
     * ��ӽ�ɫ
     * @param role
     * @param request
     * @param agent
     * @param model
     * @return
     */
    @RequestMapping("/system/role/add.htm")
    public String add(@ModelAttribute("role") SystemRole role, HttpServletRequest request,SystemUserAgent agent, Model model){
    	String funcsStr = request.getParameter("funcs");
    	List<Long> list = new ArrayList<Long>();
    	if(StringUtil.isNotBlank(funcsStr)){
    		String[] funcs = funcsStr.split(",");
    		for (int i = 0; i< funcs.length;i++){
    			if(NumberUtils.isDigits(funcs[i])){
    				list.add(Long.parseLong(funcs[i]));
    			}
    		}
    	}
    	role.setOperator(agent.getLoginName());
    	Long addedRoleId = systemRoleService.addRole(role, list);
    	String url = "/system/role/add.htm";
    	return addedRoleId!=null?redirect("/system/role/list.htm"):error(model, url, "������ɫʧ�ܣ�");
    }
    
    /**
     * �޸Ľ�ɫ��ʼ��ҳ��
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/system/role/edit-init.htm")
    public String editInit(HttpServletRequest request, Model model){
    	String id = request.getParameter("id");
    	if(StringUtil.isNotBlank(id) && NumberUtils.isDigits(id)){
    		SystemRole role = systemRoleService.getRoleById(Long.parseLong(id));
    		if(role == null){
    			String url= "/system/role/list.htm";
                return error(model, url, "��ɫ�����ڣ�");
    		}
    		model.addAttribute("role", role);
    		JSONArray data = systemRoleService.getSystemFunctionJson(role.getId());
    		int count = systemFunctionService.getFunctionCount();
    		model.addAttribute("data", data);
    		model.addAttribute("count", count);
    	}else{
            String url= "/system/role/list.htm";
            return error(model, url, "ID�����쳣��");
    	}
    	return "system/role/edit";
    }
    
    /**
     * �޸Ľ�ɫ
     * @param role
     * @param request
     * @param agent
     * @param model
     * @return
     */
    @RequestMapping("/system/role/edit.htm")
    public String edit(@ModelAttribute("role") SystemRole role,
    		HttpServletRequest request, SystemUserAgent agent, Model model){
    	String funcsStr = request.getParameter("funcs");
    	List<Long> list = new ArrayList<Long>();
    	if(StringUtil.isNotBlank(funcsStr)){
    		String[] funcs = funcsStr.split(",");
    		for(int i = 0; i<funcs.length; i++){
    			if(NumberUtils.isDigits(funcs[i])){
    				list.add(Long.parseLong(funcs[i]));
    			}
    		}
    	}
    	role.setOperator(agent.getLoginName());
    	boolean success = systemRoleService.editRole(role, list);
    	String url = "/system/role/list.htm";
        return success?redirect(url):error(model, url, "�޸Ľ�ɫʧ��!");
    }
    
    /**
     * ɾ����ɫ
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/system/role/del.htm")
    public String remove(HttpServletRequest request, Model model){
    	String id = request.getParameter("id");
    	String url = "/system/role/list.htm";
    	if (StringUtil.isNotBlank(id) && NumberUtils.isDigits(id)) {
            Long roleId = Long.parseLong(id);
            boolean isUsed = systemUserRoleService.isRoleUsed(roleId);
            if (isUsed) {
                return error(model, url, "��ɫ����ʹ���У��޷�ɾ��!");
            }
            boolean success = systemRoleService.removeRole(roleId);
            if (!success) {
                return error(model, url, "ɾ����ɫʧ�ܣ�");
            }
        } else {
            return error(model, url, "ID�����쳣��");
        }
        return success(model, url, "��ɾ����");
    }
}
