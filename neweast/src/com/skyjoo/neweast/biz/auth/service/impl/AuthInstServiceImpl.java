package com.skyjoo.neweast.biz.auth.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.auth.dao.AuthInstDAO;
import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.auth.service.AuthInstService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;

@Service
public class AuthInstServiceImpl extends BaseManager implements
		AuthInstService {
	
	@Autowired
	private AuthInstDAO authInstDAO;

	@Autowired
	private MessageDigest passwordMessageDigest;

	@Override
	public boolean checkBlank(String str) {
		boolean isBlank = StringUtil.isBlank(str);
		return isBlank;
	}

	@Override
	public boolean checkNameUnique(AuthInst systemAuth) {
	      boolean isExist = false;
	        if (StringUtil.isNotBlank(systemAuth.getName())) {
	            int count = authInstDAO.checkNameUnique(systemAuth);
	            if (count >= 1) {
	                isExist = true;
	            }
	        }
	        return isExist;
	}


	@Override
	public boolean checkcheckTelTrue(AuthInst systemAuth) {
		 String tel =  systemAuth.getTel();
	      boolean isExist = true;
	        if (isTel(tel)) {
	        	 isExist = false; 
	        }
	        return isExist;
	}
	
	/** 
     * 手机号验证 
     * @param  str 
     * @return 验证通过返回true
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); 
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  

    /** 
     * 手机号&电话 验证 
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isTel(String str) { 
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;  
        
        p = Pattern.compile("((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)"); 
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }

	@Override
	public Long addAuthInst(AuthInst systemAuth) {
		//ID,Account
		long nextSeq = authInstDAO.getNextSeq();
		String account = String.format("%06d", nextSeq);
		systemAuth.setId(nextSeq);
		systemAuth.setAccount(account);
		//password
		long pw = (long) (Math.random()*10000000);
		String pwShow = String.format("%08d", pw);
		String password = passwordMessageDigest.digest(pwShow);
		systemAuth.setPassword(password);
		
        authInstDAO.addAuthInst(systemAuth);//返回 NULL
        long id = authInstDAO.getAuthInstById(systemAuth.getId()).getId();//用于确认插入成功
        systemAuth.setPassword(pwShow);//将明文密码放回
        return id;
	}

	@Override
	public Paginable<AuthInst> getPaginatedAuthInst(Paginable<AuthInst> page) {
		return authInstDAO.getPaginatedAuthInst(page);
	}

	@Override
	public AuthInst getAuthInstById(Long authId) {
		return authInstDAO.getAuthInstById(authId);
	}

	@Override
	public int editAuthInst(AuthInst authInst) {
		return authInstDAO.updateAuthInst(authInst);
	}

	@Override
	public int resetpw(AuthInst authInst) {
		// new password
		long pw = (long) (Math.random()*10000000);
		String pwShow = String.format("%08d", pw);
		String password = passwordMessageDigest.digest(pwShow);
		authInst.setPassword(password);

        int num = authInstDAO.resetpw(authInst);
        authInst.setPassword(pwShow);//将明文密码放回
        return num;
	}

	@Override
	public int remove(Long authId) {
		int count = authInstDAO.getChertCount(authId);
		if(count>0) return -1;//鉴定机构下 有鉴定数据
		
		return authInstDAO.deleteAuthInsByID(authId);
		
	}
	
}
