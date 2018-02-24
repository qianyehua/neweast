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
  
    // ��־
    protected final Logger    logger = Logger.getLogger(this.getClass());

    @Autowired
    private   MessageSource     messageSource;
    @Autowired
    protected URLBroker         appServerBroker;
    
    protected String getMessage(Locale locale, String code, String... args) {
        return messageSource.getMessage(code, args, locale);
    }

    /**
     * �˷�����ת�������HTTPͷ��Ϣ�У������� X-FORWARDED-FOR ��Ϣ���Ը���ԭ�еĿͻ�
     * ��IP��ַ��ԭ���ͻ�������ķ�������ַ��
     * @param request ����
     * @return String �ͻ���IP��ַ
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
     * ��ʼ����
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

        // ע��˫�������ָ�ʽ������: #0.00
        NumberFormat numberFormat = new DecimalFormat("#0.00");
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
    }

    protected void registerDefaultCustomDateEditor(WebDataBinder binder) {

        // ע��Ĭ�ϵ����ڸ�ʽ������: yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * �ṩ�����ʼ����, �������Ҫ��������д�÷���
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
