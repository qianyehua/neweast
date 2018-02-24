package com.skyjoo.neweast.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.neweast.biz.system.domain.SystemUser;
import com.skyjoo.neweast.biz.system.service.SystemUserService;
import com.skyjoo.neweast.biz.system.service.UserFuncsCacheService;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.neweast.web.validator.LoginValidator;

/**
 * 登入登出
 * @author lxh
 * @version 2014-10-29 下午01:21:11
 */
@Controller
public class LoginoutAction extends BaseAction {
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private SystemUserService systemUserManager;
	@Autowired
	private MessageDigest passwordMessageDigest;
	@Autowired
	private UserFuncsCacheService userFuncsCacheService;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public void loginPage(@ModelAttribute("user") SystemUser user) {

	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") SystemUser user, BindingResult result,
			Cookyjar cookyjar, HttpServletRequest request, ModelMap model) {
		loginValidator.validate(user, result);

		if (result.hasErrors()) {
			model.put("error", "用户和密码不能为空");
			return "login";
		}
		SystemUser systemUser = systemUserManager.getSystemUserByLoginName(user.getLoginName());
		if(systemUser == null) {
			model.put("error", "用户不存在");
			return "login";
		}
		if(!passwordMessageDigest.digest(user.getPassword()).equals(systemUser.getPassword())) {
			model.put("error", "密码不正确");
			return "login";
		}
		SystemUserAgent agent = new SystemUserAgent(systemUser);
		agent.setFunctions(userFuncsCacheService.getUserFunctionIds(systemUser.getId()));
		cookyjar.set(agent);
		doLoginPost(systemUser, request);//登录后处理
		return "redirect:" + appServerBroker.get("/index.htm");
	}
	
	/**
	 * 登录后处理
	 * @param systemUser
	 * @param request
	 */
	private void doLoginPost(SystemUser systemUser, HttpServletRequest request) {
		systemUser.setLastLoginIp(systemUser.getCurrentLoginIp());
		systemUser.setGmtLastLogin(systemUser.getGmtCurrentLogin());
		systemUser.setCurrentLoginIp(getIpAddr(request));
		systemUser.setGmtCurrentLogin(new Date());
		systemUser.setLoginCount(systemUser.getLoginCount() + 1);
		systemUserManager.eidtSystemUser(systemUser, null);
	}

	@RequestMapping(value = "logout.htm")
	public String logout(SystemUserAgent agent, Cookyjar cookyjar) {
		if (agent != null) {
			cookyjar.remove(SystemUserAgent.class);
		}
		return "redirect:" + appServerBroker.get("/login.htm");
	}
}
