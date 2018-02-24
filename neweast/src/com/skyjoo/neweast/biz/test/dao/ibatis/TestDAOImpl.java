package com.skyjoo.neweast.biz.test.dao.ibatis;

import java.util.List;

import net.sf.json.JSON;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.test.dao.TestListDAO;
import com.skyjoo.neweast.biz.test.domain.test;

@Repository

@SuppressWarnings({"deprecation" })
public class TestDAOImpl extends BaseDaoiBatis implements TestListDAO{

	private static String SQLMAP_SPACE = "TEST.";
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<test> list(Pagination<test> tt) {
		try {
			super.paginate(tt, SQLMAP_SPACE + "pageCount",
                    SQLMAP_SPACE + "page");
			System.out.println(tt);
			return tt;
		} catch (Exception e) {
			//getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getAllTest");
			
			log.error(e.getStackTrace());
		}
		return null;
	}

	@Override
	public Long add(test tt) {
		return (long)getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insertTest",tt);
	}

	@Override
	public Long remove(Long id) {
		return (long) getSqlMapClientTemplate().delete(SQLMAP_SPACE+"removeTest",id);
	}

	@Override
	public Long update(test tt) {
		return  (long) getSqlMapClientTemplate().update(SQLMAP_SPACE+"updateTest", tt);
	}

	@Override
	public test obje(Long id) {
		// TODO Auto-generated method stub
		return (test)getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getTestByid",id);
	}

	
}
