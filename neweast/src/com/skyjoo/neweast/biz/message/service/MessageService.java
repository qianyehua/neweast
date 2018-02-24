package com.skyjoo.neweast.biz.message.service;

import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;

public interface MessageService {

	/**
	 * 获取评论列表分页
	 * @param messageQuery
	 */
	public void getPaginateMessage(MessageQuery messageQuery);
	
	/**
	 * 获取评论详情
	 * @param id
	 * @return
	 */
	public Message getMessageDetailById(Long id);
	
	
	/**
	 * 删除评论
	 * @param id
	 */
	public void deleteMessageById(Long id);
	
    /**
     * 添加消息
     * @param message
     * @return
     */
    public void insertMessage(Message message);
	
}
