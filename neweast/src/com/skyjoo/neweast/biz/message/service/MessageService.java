package com.skyjoo.neweast.biz.message.service;

import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;

public interface MessageService {

	/**
	 * ��ȡ�����б��ҳ
	 * @param messageQuery
	 */
	public void getPaginateMessage(MessageQuery messageQuery);
	
	/**
	 * ��ȡ��������
	 * @param id
	 * @return
	 */
	public Message getMessageDetailById(Long id);
	
	
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteMessageById(Long id);
	
    /**
     * �����Ϣ
     * @param message
     * @return
     */
    public void insertMessage(Message message);
	
}
