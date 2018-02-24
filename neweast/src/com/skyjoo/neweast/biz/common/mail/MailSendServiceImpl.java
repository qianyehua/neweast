package com.skyjoo.neweast.biz.common.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eyeieye.melos.web.url.StampURLBroker;
import com.eyeieye.melos.web.url.URLBroker;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
@Repository
public class MailSendServiceImpl implements MailSendService {
	private VelocityTemplateMailMessage mailVerifyMail;
	private VelocityTemplateMailMessage activeResetPasswordMail;
	private StampURLBroker mailImageServerBroker;
	private URLBroker mailAppServerBroker;

	@Override
	public boolean sendProcessMailVerify(String loginId, String key) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("imageServer", mailImageServerBroker.toString());
		data.put("appServer", mailAppServerBroker.toString());
		data.put("key", key);
		mailVerifyMail.setModel(data);
		mailVerifyMail.setToEmail(loginId);
		return mailVerifyMail.send();
	}

	@Override
	public boolean sendActiveResetPasswordMail(UserAccount returnAccount,
			String key, String newPassword) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("realName", returnAccount.getEmail());
		data.put("imageServer", mailImageServerBroker.toString());
		data.put("appServer", mailAppServerBroker.toString());
		data.put("key", key);
		data.put("password", newPassword);
		activeResetPasswordMail.setModel(data);
		activeResetPasswordMail.setToEmail(returnAccount.getEmail());
		return activeResetPasswordMail.send();
	}
	
	public void setMailVerifyMail(VelocityTemplateMailMessage mailVerifyMail) {
		this.mailVerifyMail = mailVerifyMail;
	}

	public void setMailImageServerBroker(StampURLBroker mailImageServerBroker) {
		this.mailImageServerBroker = mailImageServerBroker;
	}

	public void setMailAppServerBroker(URLBroker mailAppServerBroker) {
		this.mailAppServerBroker = mailAppServerBroker;
	}

	public void setActiveResetPasswordMail(
			VelocityTemplateMailMessage activeResetPasswordMail) {
		this.activeResetPasswordMail = activeResetPasswordMail;
	}

}
