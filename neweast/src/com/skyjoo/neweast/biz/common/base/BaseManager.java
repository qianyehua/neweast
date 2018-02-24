package com.skyjoo.neweast.biz.common.base;

import org.apache.log4j.Logger;

public abstract class BaseManager {

    // 日志
    protected final Logger log = Logger.getLogger(this.getClass());

    /**
     * 获得当前登录用户名
     * 
     * @return String
     */
    protected String getLoginName() {
        // TODO; 增加用户登录判断
        String loginName = null;
        /*if (SecurityContextHolder.getContext() != null
            && SecurityContextHolder.getContext().getAuthentication() != null
            && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
            loginName = user.getUsername();
        } else {
            loginName = Constants.SYSTEM_LOGIN_NAME;
        }*/
        return loginName;
    }

}
