package com.skyjoo.neweast.biz.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.test.domain.test;

public interface TestService {

	
	public Pagination<test> list(Pagination<test> tt);
	
	public test obje(Long id);
	
	public boolean add(test tt);
	
	public boolean update(test tt);
	
	public boolean remove(Long id);
	
}
