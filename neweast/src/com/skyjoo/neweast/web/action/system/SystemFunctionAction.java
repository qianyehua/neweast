/**
 * 
 */
package com.skyjoo.neweast.web.action.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.service.SystemFunctionService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 * @author wangming
 *
 */
@Controller
public class SystemFunctionAction extends BaseAction {
	@Autowired
	private SystemFunctionService systemFunctionService;
	/**
	 * ϵͳ�����б�
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/function/list.htm")
	public String list(HttpServletRequest request, Model model) {
		Long pid = 0L;
        try {
            pid = Long.parseLong(request.getParameter("pid"));
        } catch (NumberFormatException e) {
        }
        Long ppid = systemFunctionService.getParentId(pid);
        List<SystemFunction> list = systemFunctionService.getSystemFunctionByPid(pid);
        model.addAttribute("ppid", ppid);
        model.addAttribute("list_fun", list);
        model.addAttribute("pid", pid);
        return "system/function/list";
    }
	/**
	 * ���ϵͳ���� ����ʼ��addҳ��
	 * @param fun
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/function/add-init.htm")
	public String addInit(@ModelAttribute("fun") SystemFunction fun, Model model){
		model.addAttribute("list_menus", systemFunctionService.getSystemFunctionSelNames());
		return "system/function/add";
	}
	/**
	 * ���ϵͳ����
	 * @param fun
	 * @param result
	 * @return
	 */
	@RequestMapping("/system/function/add.htm")
	public String add(@ModelAttribute("fun") SystemFunction fun,SystemUserAgent agent, Model model){
		fun.setOperator(agent.getLoginName());
		Long i = systemFunctionService.addSystemFunction(fun);
		String url = "/system/function/list.htm?pid="+fun.getParentId();
		model.addAttribute("url", url);
		return i>0?success(model, url, "����ϵͳ���ܳɹ���"):error(model,"����ϵͳ����ʧ�ܣ�");
	}
	
	/**
	 * �޸�ϵͳ���ܣ���ʼ��editҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/function/edit-init.htm")
	public String editInit(@RequestParam("id")Long id,Model model){
		SystemFunction fun = systemFunctionService.getSystemFunctionById(id);
		model.addAttribute("fun", fun);
		model.addAttribute("list_menus", systemFunctionService.getSystemFunctionEditNames(id));
		return "system/function/edit";
	}
	
	/**
	 * �޸�ϵͳ����
	 * @param fun
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/function/edit.htm")
    public String edit(@ModelAttribute("fun") SystemFunction fun,SystemUserAgent agent, Model model) {
		fun.setOperator(agent.getLoginName());
		int i = systemFunctionService.editSystemFunction(fun);
		String url = "/system/function/list.htm?pid="+fun.getParentId();
		model.addAttribute("url", url);
		return i>0?success(model, url, "�޸ĳɹ���"):error(model,url,"�޸Ĳ���δ�ɹ���");
	}
	
	/**
	 * ɾ��ϵͳ����
	 * @param id ϵͳ����id
	 * @param pid ����ϵͳ����id
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/function/remove.htm")
    public String remove(@RequestParam("id")Long id,@RequestParam("pid")Long pid, Model model){
		int i = systemFunctionService.removeSystemFunction(id);
		String url = "/system/function/list.htm?pid="+pid;
		model.addAttribute("url", url);
		return i>0?success(model, url, "��ɾ����"):error(model,"ɾ����Ա����δ�ɹ���");
	}
}
