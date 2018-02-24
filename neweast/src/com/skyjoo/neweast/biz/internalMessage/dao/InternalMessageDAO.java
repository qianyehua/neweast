package com.skyjoo.neweast.biz.internalMessage.dao;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;

public interface InternalMessageDAO {
	
	/**
	 * 获取所有站内信 分页
	 * @param page
	 * @return
	 */
	public Paginable<CommInternalMessage> getPaginateInternalMessage(Paginable<CommInternalMessage> page); 

	/**
	 * 通过id获取站内信
	 * @param messageId
	 * @return
	 */
	public List<CommInternalMessage> getInternalMessageById(Long messageId);
	
	/**
	 * 将站内信设为已读
	 * @param messageId
	 * @return
	 */
	public Integer setHaveRead(Long messageId);
	
	/**
	 * 将站内信设为已回复
	 * @param messageId
	 * @return
	 */
	public Integer setHaveReplied(Map<String,Long> map);
	
	/**
	 * 站内信回复
	 * @param message
	 * @return
	 */
	public Long addInternalMessage(CommInternalMessage message);
}
