package com.skyjoo.neweast.biz.common.base;

import org.apache.log4j.Logger;

public abstract class BaseManager {

    // ��־
    protected final Logger log = Logger.getLogger(this.getClass());

    /**
     * ��õ�ǰ��¼�û���
     * 
     * @return String
     */
    protected String getLoginName() {
        // TODO; �����û���¼�ж�
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
