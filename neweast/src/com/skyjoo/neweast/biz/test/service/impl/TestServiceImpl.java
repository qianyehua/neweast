package com.skyjoo.neweast.biz.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.test.dao.TestListDAO;
import com.skyjoo.neweast.biz.test.domain.test;
import com.skyjoo.neweast.biz.test.service.TestService;
@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestListDAO testdao;
	
	@Override
	public Pagination<test> list(Pagination<test> tt) {
		
		return testdao.list(tt);
	}

	@Override
	public boolean add(test tt) {
		int bo=testdao.add(tt).intValue();
		return bo !=0 ? true : false;
	}

	@Override
	public boolean update(test tt) {
		int bo=testdao.update(tt).intValue();
		return bo ==1 ? true : false;
	}

	@Override
	public boolean remove(Long id) {
		int bo=testdao.remove(id).intValue();
		return bo ==1 ? true : false;
	}

	@Override
	public test obje(Long id) {
		// TODO Auto-generated method stub
		return testdao.obje(id);
	}

	
}
