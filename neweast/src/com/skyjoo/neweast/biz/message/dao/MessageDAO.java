package com.skyjoo.neweast.biz.message.dao;

import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;

public interface MessageDAO {


	/**
	 * ��ȡ���۷�ҳ�б�
	 * @param messageQuery
	 */
	public void  getPaginateMessage(MessageQuery messageQuery);
	
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
	public void  deleteMessageById(Long id);
	
	   
    /**
     * �����Ϣ
     * @param message
     * @return
     */
    public Long insertMessage(Message message);
	
}
