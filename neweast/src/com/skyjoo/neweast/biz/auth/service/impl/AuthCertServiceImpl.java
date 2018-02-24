package com.skyjoo.neweast.biz.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.auth.dao.AuthCertDAO;
import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.auth.service.AuthCertService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.upload.UploadManager;

@Service
public class AuthCertServiceImpl extends BaseManager implements
		AuthCertService {
	
	@Autowired
	private AuthCertDAO authCertDAO;	
	@Autowired
	private UploadManager uploadManager;

	@Override
	public Paginable<AuthCertQurty> getPaginatedAuthCertQuery(
			Paginable<AuthCertQurty> qurty) {
		Paginable<AuthCertQurty> rst= authCertDAO.getPaginatedAuthCertQuery(qurty);
		return rst;
	}

	@Override
	public AuthCertQurty getAuthCertQueryById(long id) {
		return authCertDAO.getAuthCertQueryById(id);
	}

	@Override
	public int remove(long id) {
		AuthCertQurty query =authCertDAO.getAuthCertQueryById(id);
		//ÒÆ³ýÍ¼Æ¬
		uploadManager.deleteFile("", query.getCertPic());
		//ÒÆ³ýÊý¾Ý
		return authCertDAO.remove(id);
	}

	
}
