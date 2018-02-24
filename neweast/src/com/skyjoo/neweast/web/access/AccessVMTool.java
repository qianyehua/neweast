package com.skyjoo.neweast.web.access;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.tools.view.context.ViewContext;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.neweast.biz.system.service.UserFuncsCacheService;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

public class AccessVMTool {
	
	private SystemUserAgent agent;
	private UserFuncsCacheService userFuncsCacheService;

	public void init(Object obj) {
		if (!(obj instanceof ViewContext)) {
			throw new IllegalArgumentException(
					"Tool can only be initialized with a ViewContext");
		}
		ViewContext viewContext = (ViewContext) obj;
		HttpServletRequest request = viewContext.getRequest();
		Cookyjar cookyjar = (Cookyjar) request
				.getAttribute(Cookyjar.CookyjarInRequest);
		if (cookyjar == null) {
			throw new IllegalStateException(
					"Cookyjar not find in HttpServletRequest");
		}
		agent = (SystemUserAgent) cookyjar.getObject(SystemUserAgent.class);
		userFuncsCacheService = (UserFuncsCacheService) request.getAttribute(AccessFunctionFilter.FilteredTag);
	}
	
	/**
	 * 在指定的2进制位上是否有权限
	 * 
	 * @param index
	 * @return
	 */
	public boolean haveFunction(Long index) {
		int indexReal = (int) (index - userFuncsCacheService.getOffset());
		return agent.haveFunction(indexReal);
	}
	
	/**
	 * 是否有访问该URL的权限
	 * @param url
	 * @return
	 */
	public boolean haveFunction(String url) {
		int indexReal = userFuncsCacheService.getFunctionOffsetId(url);
		return agent.haveFunction(indexReal);
	}
}
