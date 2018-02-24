package com.skyjoo.neweast.biz.common.mail;

import com.skyjoo.neweast.biz.account.domain.UserAccount;



/**
 * �ʼ�����service
 * @author lxh
 *
 */
public interface MailSendService {
	
	/**
	 * ������֤���������ʼ�
	 * @param loginId
	 * @param key
	 * @return
	 */
    public boolean sendProcessMailVerify(String loginId, String key);

    /**
     * ���ͻ�Ա��������ҳ��
     * @param returnAccount
     * @param key
     * @param newPassword
     * @return
     */
	public boolean sendActiveResetPasswordMail(UserAccount returnAccount, String key, String newPassword);
}
