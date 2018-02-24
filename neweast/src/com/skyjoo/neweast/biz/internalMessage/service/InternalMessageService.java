package com.skyjoo.neweast.biz.internalMessage.service;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;

public interface InternalMessageService {

	/**
	 * ��ȡ����վ���� ��ҳ
	 * @param page
	 * @return
	 */
	public Paginable<CommInternalMessage> getPaginateInternalMessage(Paginable<CommInternalMessage> page); 
	
	/**
	 * ͨ��id��ȡվ����
	 * @param messageId
	 * @return
	 */
	public CommInternalMessage getInternalMessageById(Long messageId);
	
	/**
	 * ��վ���Ÿ�Ϊ�Ѷ�
	 * @param messageid
	 * @return
	 */
	public Integer setHaveRead(Long id);
	
	/**
	 * վ���Żظ�
	 * @param message
	 * @return
	 */
	public Integer addInternalMessage(CommInternalMessage message);

}
