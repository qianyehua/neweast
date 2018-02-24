package com.skyjoo.neweast.biz.internalMessage.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.internalMessage.dao.InternalMessageDAO;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;

@SuppressWarnings("deprecation")
@Repository
public class InternalMessageDaoImpl extends BaseDaoiBatis implements
		InternalMessageDAO {
	
	private static final String SQLMAP_SPACE = "COMM_INTERNAL_MESSEGE.";
	@Autowired
	private SqlMapClientTemplate sqlMapClient;

	@Override
	public Paginable<CommInternalMessage> getPaginateInternalMessage(
			Paginable<CommInternalMessage> page) {
		super.paginate(page, SQLMAP_SPACE+"getTotalCount", SQLMAP_SPACE+"getInternalMessagePage");
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommInternalMessage> getInternalMessageById(Long messageId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getInternalMesaageById", messageId);
	}

	@Override
	public Integer setHaveRead(Long messageId) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"setHaveRead", messageId);
	}

	@Override
	public Integer setHaveReplied(Map<String,Long> map) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"setHaveReplied", map);
	}

	@Override
	public Long addInternalMessage(CommInternalMessage message) {
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"addInternalMessage", message);
	}

}
