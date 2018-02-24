package com.skyjoo.neweast.web.cookyjar;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.eyeieye.melos.web.cookyjar.Cookyjar;

/**
 * ϵͳ�û�����ע��
 * @author lxh
 * @version 2014-10-29 ����04:20:37
 */
public class SystemUserAgentArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter,
			ModelAndViewContainer mav, NativeWebRequest webRequest,
			WebDataBinderFactory binder) throws Exception {
		Cookyjar cookyjar = (Cookyjar) webRequest.getAttribute(Cookyjar.CookyjarInRequest, RequestAttributes.SCOPE_REQUEST);
		if (cookyjar != null) {
			return cookyjar.getObject(SystemUserAgent.class);
		}
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(SystemUserAgent.class);
	}
}
