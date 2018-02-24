package com.skyjoo.neweast.biz.message.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.message.dao.MessageDAO;
import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;
import com.skyjoo.neweast.biz.message.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDAO messageDAO;
	
    @Autowired
    private ExecutorService messageExecutor = Executors.newFixedThreadPool(20);

	@Override
	public void getPaginateMessage(MessageQuery messageQuery) {
		messageDAO.getPaginateMessage(messageQuery);
	}

	@Override
	public Message getMessageDetailById(Long id) {
		return messageDAO.getMessageDetailById(id);
	}

	@Override
	public void deleteMessageById(Long id) {
		messageDAO.deleteMessageById(id);
	}

    @Override
    public void insertMessage(final Message message) {
        if(message!=null){
            messageExecutor.execute(new Runnable() {    
                @Override
                public void run() {
                    messageDAO.insertMessage(message);
                }
            });  
        }
    }
	

}
