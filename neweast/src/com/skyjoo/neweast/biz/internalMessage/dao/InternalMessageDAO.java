package com.skyjoo.neweast.biz.internalMessage.dao;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;

public interface InternalMessageDAO {
	
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
	public List<CommInternalMessage> getInternalMessageById(Long messageId);
	
	/**
	 * ��վ������Ϊ�Ѷ�
	 * @param messageId
	 * @return
	 */
	public Integer setHaveRead(Long messageId);
	
	/**
	 * ��վ������Ϊ�ѻظ�
	 * @param messageId
	 * @return
	 */
	public Integer setHaveReplied(Map<String,Long> map);
	
	/**
	 * վ���Żظ�
	 * @param message
	 * @return
	 */
	public Long addInternalMessage(CommInternalMessage message);
}
