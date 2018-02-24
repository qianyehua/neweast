package com.skyjoo.neweast.biz.common.mail;

import com.skyjoo.neweast.biz.account.domain.UserAccount;



/**
 * 邮件发送service
 * @author lxh
 *
 */
public interface MailSendService {
	
	/**
	 * 发送验证开户流程邮件
	 * @param loginId
	 * @param key
	 * @return
	 */
    public boolean sendProcessMailVerify(String loginId, String key);

    /**
     * 发送会员密码重置页面
     * @param returnAccount
     * @param key
     * @param newPassword
     * @return
     */
	public boolean sendActiveResetPasswordMail(UserAccount returnAccount, String key, String newPassword);
}
