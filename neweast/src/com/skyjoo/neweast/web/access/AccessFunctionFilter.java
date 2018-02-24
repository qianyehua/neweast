package com.skyjoo.neweast.web.access;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.skyjoo.neweast.biz.system.service.UserFuncsCacheService;

public class AccessFunctionFilter implements Filter {

	public static final String FilteredTag = "functions";
	private UserFuncsCacheService userFuncsCacheService;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getAttribute(FilteredTag) != null) {
			chain.doFilter(request, response);
			return;
		} else {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			httpRequest.setAttribute(FilteredTag, userFuncsCacheService);
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void setUserFuncsCacheService(UserFuncsCacheService userFuncsCacheService) {
		this.userFuncsCacheService = userFuncsCacheService;
	}

}
