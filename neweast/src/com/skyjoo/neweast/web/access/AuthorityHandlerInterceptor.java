package com.skyjoo.neweast.web.access;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.neweast.biz.system.service.UserFuncsCacheService;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

public class AuthorityHandlerInterceptor extends HandlerInterceptorAdapter {

	private List<String> uncheckPattern = new ArrayList<String>();
	private UserFuncsCacheService userFuncsCacheService;
	
	/**
	 * 是否拦截
	 * @param url
	 * @return
	 */
	private boolean needCheck(String url) {
		if(uncheckPattern.size() > 0) {
			for (String path : uncheckPattern) {
				if(url.matches(path)) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getServletPath().toString();
		if(!needCheck(url)) {
			return true;
		}
		Cookyjar cookyjar = (Cookyjar) request.getAttribute(Cookyjar.CookyjarInRequest);
		if (cookyjar == null) {
			throw new IllegalStateException("cookyjar not find in request");
		}
		SystemUserAgent userAgent = (SystemUserAgent) cookyjar.getObject(SystemUserAgent.class);
		if(userAgent == null) {
			 throw new AccessLoginException();
		}
		//检测角色的URL权限
		/*if(request.getQueryString() != null) {
			url = url + "?" + request.getQueryString();
		}*/
		//modify by kanghl 忽略url问号以后的参数
		if(url.contains("?")){
			int i=url.indexOf("?");
			url=url.substring(0,i);
		}
		if(!checkMenu(userAgent, url)) {
			throw new AccessDeniedException("无权限");
		}
		return true;
	}
	
	private boolean checkMenu(SystemUserAgent userAgent, String url) {
		Integer index = userFuncsCacheService.getFunctionOffsetId(url);
		if(index == null) {
			return true;
		}
			
		return userAgent.haveFunction(index);
	}

	public void setUncheckPattern(List<String> uncheckPattern) {
		this.uncheckPattern = uncheckPattern;
	}
	public void setUserFuncsCacheService(UserFuncsCacheService userFuncsCacheService) {
		this.userFuncsCacheService = userFuncsCacheService;
	}

}
