package com.skyjoo.neweast.biz.test.dao;

import java.util.List;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.test.domain.test;

public interface TestListDAO {
	/*
	     ��ȡ���в�������  
	 */
	
	public Pagination<test> list(Pagination<test> tt);
	
	//����id��ȡ����
	public test obje(Long id);
	
	//���Ӳ�������
	public Long  add(test tt);
	
	
	//ɾ����������
	public Long  remove(Long id);

    //�޸Ĳ�������
	public Long update(test tt);
}
