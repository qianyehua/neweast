package com.skyjoo.neweast.biz.internalMessage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.dao.InternalMessageDAO;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;
import com.skyjoo.neweast.biz.internalMessage.service.InternalMessageService;

@Service
public class IntenalMessageServiceImpl extends BaseManager implements
		InternalMessageService {
	
	@Autowired
	private InternalMessageDAO internalMessageDAO;

	@Override
	public Paginable<CommInternalMessage> getPaginateInternalMessage(
			Paginable<CommInternalMessage> page) {
		return internalMessageDAO.getPaginateInternalMessage(page);
	}

	@Override
	public CommInternalMessage getInternalMessageById(Long messageId) {
		List<CommInternalMessage> list = internalMessageDAO.getInternalMessageById(messageId);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer setHaveRead(Long id) {
		return internalMessageDAO.setHaveRead(id);
	}

	@Override
	public Integer addInternalMessage(CommInternalMessage message) {
		Long addKey = internalMessageDAO.addInternalMessage(message);
		if(addKey == null){
			return 0;
		}
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("replyId", addKey);
		map.put("id", Long.parseLong(message.getMessageId()));
		return internalMessageDAO.setHaveReplied(map);		
	}

}
