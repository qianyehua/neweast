package com.skyjoo.neweast.web.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.system.domain.SystemRole;
import com.skyjoo.neweast.biz.system.domain.SystemUser;
import com.skyjoo.neweast.biz.system.domain.SystemUserRole;
import com.skyjoo.neweast.biz.system.service.SystemRoleService;
import com.skyjoo.neweast.biz.system.service.SystemUserRoleService;
import com.skyjoo.neweast.biz.system.service.SystemUserService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
/**
 * @author wangming
 *
 */
@Controller
public class SystemUserAction extends BaseAction {

    @Autowired
    SystemUserService            systemUserService;
    @Autowired
    private SystemRoleService     systemRoleService;
    @Autowired
    private SystemUserRoleService systemUserRoleService;
    @Autowired
	private MessageDigest passwordMessageDigest;
    private static String initPassword = "takung123!@#";
    
    /**
     * 初始化角色
     * @param model
     * @param userId
     */
    private void initRoles(Model model, Long userId) {
        List<SystemRole> roles = systemRoleService.getRoles();
        model.addAttribute("roles", roles);
        if (userId != null) {
            List<SystemRole> newroles = new ArrayList<SystemRole>();
            List<SystemUserRole> userRoles = systemUserRoleService.getUserRoleByUserId(userId);
            for (SystemRole role : roles) {
                for (SystemUserRole userRole : userRoles) {
                    if (userRole.getRoleId().longValue() == role.getId().longValue()) {
                        role.setSelected(true);
                    }
                }
                newroles.add(role);
            }
            model.addAttribute("roles", newroles);
        }

    }

    /**
     *用户列表页面
    * @author wm
    * @param systemUser
    * @param model
    * @return string
    */
    @RequestMapping(value = "/system/user/list.htm")
    public String list(SystemUser systemUser, Model model) {
        String userName = systemUser.getLoginName();
        if (userName != null) {
            systemUser.setLoginName(userName.trim());
        }
        systemUser =  (SystemUser)systemUserService.getPaginatedSystemUser(systemUser);
        model.addAttribute("page", systemUser);
        return "system/user/list";
    }

    /**
     * 用户页面展示
     * @param request
     * @param model
     * @return string
     * @author wm
     */
    @RequestMapping("/system/user/add-init.htm")
    public String addInit(SystemUser systemUser, Model model) {
    	initRoles(model, null);
        return "system/user/add";
    }

    /**
     *添加用户
     * @param systemUser
     * @param result
     * @return
     * @author wm
     */
    @RequestMapping(value = "/system/user/add.htm")
    public String add(@ModelAttribute("systemUser") SystemUser systemUser, BindingResult result,
                      HttpServletRequest request, Model model, SystemUserAgent agent) {
        boolean hasError = false;
        systemUser.setOperator(agent.getLoginName());
        systemUser.setLoginCount(0);
        if (systemUserService.checkTelAndMobile(systemUser.getTel(), systemUser.getMobile())) {
            hasError = true;
            model.addAttribute("isTelAndMobileInValid", true);
        }
        if (systemUser.getLoginName().toLowerCase().equals("system")) {
            hasError = true;
            model.addAttribute("hasSystemUser", true);
        }
        if (systemUserService.checkLoginNameUnique(systemUser)) {
            hasError = true;
            model.addAttribute("hasRegister", true);

        }
        if (!systemUser.getPassword().equals(systemUser.getRePassword())) {
            hasError = true;
            model.addAttribute("hasPasswordError", true);
        }
        if (hasError) {
            initRoles(model, null);
            return "system/user/add";
        }
        String password = systemUser.getPassword();
        systemUser.setPassword(password);
        String rolesStr = request.getParameter("roles");
        List<Long> roles = new ArrayList<Long>();
        if (StringUtil.isNotBlank(rolesStr)) {
            String[] strs = rolesStr.split(",");
            for (int i = 0; i < strs.length; i++) {
                if (NumberUtils.isDigits(strs[i])) {
                    roles.add(Long.parseLong(strs[i]));
                }
            }
        }
        Long addedUserId = systemUserService.addSystemUser(systemUser, roles);
        String url = "/system/user/list.htm";
        return addedUserId>0?success(model, url, "添加成功！"):error(model, url, "用户添加失败！");
    }

    /**
     *修改用户页面
     * @param systemUser
     * @param result
     * @return
     * @author wm
     */
    @RequestMapping(value = "/system/user/edit-init.htm")
    public String editInit(@RequestParam("id") Long userId,
                           @ModelAttribute("systemUser") SystemUser systemUser, Model model) {
    	systemUser = systemUserService.getSystemUserById(userId);
        systemUser.setPassword(null);
        initRoles(model, userId);
        model.addAttribute("userId", userId);
        model.addAttribute("systemUser", systemUser);
        return "system/user/edit";
    }

    /**
     *修改用户
     * @param systemUser
     * @param result
     * @return
     * @author wm
     */
    @RequestMapping(value = "/system/user/edit.htm")
    public String edit(@RequestParam("id") Long userId,
                       @ModelAttribute("systemUser") SystemUser systemUser,
                       HttpServletRequest request, SystemUserAgent agent, Model model) {
        boolean hasError = false;
        systemUser.setId(userId);
        systemUser.setOperator(agent.getLoginName());
        if (systemUserService.checkLoginNameUnique(systemUser)) {
            hasError = true;
            model.addAttribute("hasRegister", true);
        }
        if (systemUser.getLoginName().toLowerCase().equals("system")) {
            hasError = true;
            model.addAttribute("hasSystemUser", true);
        }
        if (systemUser.getLoginName().toLowerCase().equals("system")) {
            hasError = true;
            model.addAttribute("hasSystemUser", true);
        }
        if (systemUserService.checkTelAndMobile(systemUser.getTel(), systemUser.getMobile())) {
        	hasError = true;
            model.addAttribute("isTelAndMobileInValid", true);
        }
        if (hasError) {
            initRoles(model, userId);
            return "system/user/edit";
        }
        String rolesStr = request.getParameter("roles");
        List<Long> selRoles = new ArrayList<Long>();
        if (StringUtil.isNotBlank(rolesStr)) {
            String[] strs = rolesStr.split(",");
            for (int i = 0; i < strs.length; i++) {
                if (NumberUtils.isDigits(strs[i])) {
                    selRoles.add(Long.parseLong(strs[i]));
                }
            }
        }
        int i = systemUserService.eidtSystemUser(systemUser,selRoles);
        String url = "/system/user/list.htm";
        return i>0?success(model, url, "修改成功！"):error(model, url, "修改失败！");
    }
    
    /**
     * 初始化密码
     */
    @RequestMapping("/system/user/initPassword.htm")
    public String initPassword(@ModelAttribute("systemUser")SystemUser systemUser,Model model){
    	systemUser.setId(systemUser.getId());
    	systemUser.setPassword(passwordMessageDigest.digest(initPassword));
    	int i = systemUserService.initPassword(systemUser);
    	if(i>0){
    		model.addAttribute("message", "初始化密码成功");
    		return "success";
    	}
    	model.addAttribute("message", "初始化密码失败");
    	return "error";
    }

    /**
     *删除用户
     * @param systemUser
     * @param result
     * @return
     * @author wm
     */
    @RequestMapping(value = "/system/user/remove.htm")
    public String remove(@RequestParam("id") Long userId,Model model) {
    	String url = "/system/user/list.htm";
    	if (userId != null) {
            int i = systemUserService.removeSystemUser(userId);
            return i>0?success(model, url, "已删除！"):error(model, url, "删除失败！");
        } else {
            return error(model, url, "ID参数异常！");
        }
    }

    /**
     *	当前用户修改个人信息初始化页面
     * @param systemUser
     * @param result
     * @return
     * @author wm
     */
    @RequestMapping(value = "/system/ownInfo/list.htm")
    public String ownInfoInit(Model model, @ModelAttribute("systemUser") SystemUser systemUser,SystemUserAgent agent) {
        systemUser = systemUserService.getSystemUserByLoginName(agent.getLoginName());
        systemUser.setPassword(null);
        model.addAttribute(systemUser);
        return "system/user/ownInfo";
    }

    /**
     * 当前用户修改个人信息
     * @param systemUser
     * @param result
     * @return
     * @author 
     */
    @RequestMapping(value = "/system/ownInfo/update.htm")
    public String ownInfoUpdate(Model model, @ModelAttribute("systemUser") SystemUser systemUser,
                               SystemUserAgent agent, BindingResult result) {
    	SystemUser dbSystemUser = systemUserService.getSystemUserByLoginName(agent.getLoginName());
    	String url = "/system/user/ownInfo";
        if (systemUserService.checkLoginNameUnique(systemUser)) {
            model.addAttribute("hasRegister", true);
            return url;
        }
        if (systemUser.getLoginName().toLowerCase().equals("system")) {
            model.addAttribute("hasSystemUser", true);
            return url;
        }
        if (!passwordMessageDigest.digest(systemUser.getOldPassword()).equals(dbSystemUser.getPassword())) {
                model.addAttribute("isPasswordInValid", true);
                return url;
        }else{
        	if (!systemUser.getPassword().equals(systemUser.getRePassword())) {
                model.addAttribute("hasPasswordError", true);
                return url;
            }else{
            	systemUser.setOperator(agent.getLoginName());
                int i = systemUserService.updateOwnInfo(systemUser);
                model.addAttribute("url", "/system/ownInfo/list.htm");
                if(i>0){
                	model.addAttribute("message", "修改成功！");
                	return "success";
                }else{
                	model.addAttribute("message", "修改失败！");
                	return "error";
                }
            }
        }
    }
}
