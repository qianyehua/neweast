package com.skyjoo.neweast.biz.point.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.point.dao.PointChangeLogDao;
import com.skyjoo.neweast.biz.point.domain.ExcelCell;
import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;
import com.skyjoo.neweast.biz.point.service.PointChangeLogServer;

@Service
public class PointChangeLogServerImpl extends BaseManager implements
		PointChangeLogServer {
	@Autowired
	private PointChangeLogDao pointChangeLogDao;

	@Override
	public void list(PointChangeLogQuery pclq) {
		pointChangeLogDao.list(pclq);
	}

}
