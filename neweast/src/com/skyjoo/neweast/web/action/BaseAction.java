package com.skyjoo.neweast.web.action;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eyeieye.melos.web.url.URLBroker;

@Controller
public class BaseAction {
  
    // 日志
    protected final Logger    logger = Logger.getLogger(this.getClass());

    @Autowired
    private   MessageSource     messageSource;
    @Autowired
    protected URLBroker         appServerBroker;
    
    protected String getMessage(Locale locale, String code, String... args) {
        return messageSource.getMessage(code, args, locale);
    }

    /**
     * 此方法在转发请求的HTTP头信息中，增加了 X-FORWARDED-FOR 信息用以跟踪原有的客户
     * 端IP地址和原来客户端请求的服务器地址。
     * @param request 请求
     * @return String 客户端IP地址
     */
    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    /**
     * 初始化绑定
     * 
     * @param binder
     */
    @InitBinder
    protected final void initBinderInternal(WebDataBinder binder) {

        registerDefaultCustomDateEditor(binder);
        registerDefaultCustomNumberEditor(binder);
        initBinder(binder);
    }

    private void registerDefaultCustomNumberEditor(WebDataBinder binder) {

        // 注册双精度数字格式化类型: #0.00
        NumberFormat numberFormat = new DecimalFormat("#0.00");
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
    }

    protected void registerDefaultCustomDateEditor(WebDataBinder binder) {

        // 注册默认的日期格式化类型: yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 提供子类初始化表单, 子类如果要调用请重写该方法
     * 
     * @param binder
     */
    protected void initBinder(WebDataBinder binder) {
    }


    protected String redirect(String url) {
        return "redirect:" + appServerBroker + url;
    }

    protected String redirectLogin() {
        return redirect("/login.htm");
    }
    
    protected String success() {
        return redirect("/success.htm");
    }

    protected String error() {
        return redirect("/error.htm");
    }

    protected String success(ModelMap model) {
        return "success";
    }

    protected String error(ModelMap model) {
        return "error";
    }

    protected String success(Model model, String code, String... args) {
        String message = messageSource.getMessage(code, args, Locale.CHINA);
        model.addAttribute("message", message);
        return "success";
    }

    protected String success(ModelMap model, String code, String... args) {
        String message = messageSource.getMessage(code, args, Locale.CHINA);
        model.addAttribute("message", message);
        return "success";
    }

    protected String error(Model model, String code, String... args) {
        String message = messageSource.getMessage(code, args, Locale.CHINA);
        model.addAttribute("message", message);
        return "error";
    }

    protected String error(ModelMap model, String code, String... args) {
        String message = messageSource.getMessage(code, args, Locale.CHINA);
        model.addAttribute("message", message);
        return "error";
    }
    protected String success(Model model,String url,String msg){
    	model.addAttribute("url",url);
    	model.addAttribute("message",msg);
    	return "success";
    }
    
    
    protected String error(Model model,String url,String msg){
    	model.addAttribute("url",url);
    	model.addAttribute("message",msg);
    	return "error";
    }
    
}
