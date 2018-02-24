package com.skyjoo.neweast.web.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.skyjoo.neweast.web.access.AccessDeniedException;
import com.skyjoo.neweast.web.access.AccessLoginException;

/**
 * 
 * @author fish
 * 
 */
@ControllerAdvice
public class NeweastExceptionHandler {
	private static final Log logger = LogFactory
			.getLog(NeweastExceptionHandler.class);

	private String errorPage = "/error";

	private String noPermissionPage = "/denied";
	
	private String loginPage = "redirect:/login.htm";

	@ExceptionHandler(AccessLoginException.class)
	public ModelAndView handleLoginException(HttpServletRequest request,
			AccessLoginException ex) {
		return new ModelAndView(loginPage);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(HttpServletRequest request,
			AccessDeniedException ex) {
		return noPermissionPage;
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error("error in url:" + request.getRequestURI(), ex);
		return errorPage;
	}
}
