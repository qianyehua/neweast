package com.skyjoo.neweast.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.service.SystemFunctionService;
import com.skyjoo.neweast.biz.system.service.SystemUserService;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

@Controller
public class IndexAction extends BaseAction {
	@Autowired
	private SystemFunctionService systemFunctionService;
	@Autowired
	private SystemUserService systemUserService;
    
    /**
     * 默认首页处理
     * @param model
     */
    @RequestMapping("/main.htm")
    public void index(SystemUserAgent agent, ModelMap model) {
    	model.put("user", systemUserService.getSystemUserById(agent.getId()));
    }

    /**
     * 菜单处理
     * @param request
     * @param model
     * @return String
     */
    @RequestMapping("/contain/menu.htm")
    public String menu(SystemUserAgent agent, ModelMap model) {
    	List<SystemFunction> functionList = systemFunctionService.getMenus();
    	model.put("menus", functionList);
        return "contain/menu";
    }
    
}
