package com.skyjoo.neweast.biz.common.base;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.SimplePage;


/**
 * Dao����
 * 
 * @author zhengdd
 * @version $Id: BaseDao.java,v 0.1 2010-3-19 ����11:12:56 zhengdd Exp $
 */
@SuppressWarnings("deprecation")
public abstract class BaseDaoiBatis {
	// ��־
    protected final Logger log = Logger.getLogger(this.getClass());
    
	protected int                batchSize = 500;

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }

    /**
     * ���ݷ�ҳ������ȡ��ҳ��Ϣ, ����page����ĿǰĬ�ϲ���SimplePage��������
     * 
     * @param <T>
     * @param page ��ҳ��Ϣ
     * @param qTotalCount
     * @param qPagination
     */
    @SuppressWarnings("unchecked")
	public final <T> void paginate(Paginable<T> page, String qTotalCount, String qPagination) {
        if (!(page instanceof SimplePage)) {
            throw new IllegalArgumentException("'page' argument is unsupport class type, " + "it must be "
                                               + SimplePage.class.getName() + " or subclass");
        }
        int totalCount = (Integer) getSqlMapClientTemplate().queryForObject(qTotalCount, page);
        if (totalCount > 0) {
            SimplePage<T> _page = (SimplePage<T>) page;
            _page.setTotalCount(totalCount);
            _page.setData(this.getSqlMapClientTemplate().queryForList(qPagination, page));
        }
    }

    /**
     * ����Ҫ��ҳ���������Ϣ (���Բ���Ҫ������)
     * @param <T>
     * @param page 
     * @param qPagination
     */
    @SuppressWarnings("unchecked")
    public final <T> void paginate(Paginable<T> page, String qPagination) {
        if (!(page instanceof SimplePage)) {
            throw new IllegalArgumentException("'page' argument is unsupport class type, " + "it must be "
                                               + SimplePage.class.getName() + " or subclass");
        }
        List<T> result = getSqlMapClientTemplate().queryForList(qPagination, page);
        if (result != null) {
            SimplePage<T> _page = (SimplePage<T>) page;
            _page.setPageSize(result.size());
            _page.setTotalCount(result.size());
            _page.setData(result);
        }
    }

}
