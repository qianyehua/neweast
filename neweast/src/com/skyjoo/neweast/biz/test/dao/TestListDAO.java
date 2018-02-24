package com.skyjoo.neweast.biz.test.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.test.domain.test;

public interface TestListDAO {
	/*
	     获取所有测试数据  
	 */
	
	public Pagination<test> list(Pagination<test> tt);
	
	//根据id获取数据
	public test obje(Long id);
	
	//增加测试数据
	public Long  add(test tt);
	
	
	//删除测试数据
	public Long  remove(Long id);

    //修改测试数据
	public Long update(test tt);
}
