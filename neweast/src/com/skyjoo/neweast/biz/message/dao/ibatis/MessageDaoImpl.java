package com.skyjoo.neweast.biz.message.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.message.dao.MessageDAO;
import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;
@SuppressWarnings("deprecation")
@Repository
public class MessageDaoImpl  extends BaseDaoiBatis implements MessageDAO {
	
	private static final String SQLMAP_SPACE = "COMM_MESSAGE.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;


	@Override
	public void getPaginateMessage(MessageQuery messageQuery) {
		super.paginate(messageQuery, SQLMAP_SPACE+"getMessageCount", SQLMAP_SPACE+"getPaginateMessage");
	}


	@Override
	public Message getMessageDetailById(Long id) {
		return (Message) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getMessageDetailById", id);
	}


	@Override
	public void deleteMessageById(Long id) {
		this.sqlMapClient.delete(SQLMAP_SPACE+"deleteMessageById", id);
		
	}


    @Override
    public Long insertMessage(Message message) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"insertMessage", message);
    }

}
