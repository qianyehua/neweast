package com.skyjoo.neweast.biz.internalMessage.service;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;

public interface InternalMessageService {

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
	public CommInternalMessage getInternalMessageById(Long messageId);
	
	/**
	 * 将站内信改为已读
	 * @param messageid
	 * @return
	 */
	public Integer setHaveRead(Long id);
	
	/**
	 * 站内信回复
	 * @param message
	 * @return
	 */
	public Integer addInternalMessage(CommInternalMessage message);

}
