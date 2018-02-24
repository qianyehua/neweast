package com.skyjoo.neweast.biz.common.base;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.page.SimplePage;


/**
 * Dao基类
 * 
 * @author zhengdd
 * @version $Id: BaseDao.java,v 0.1 2010-3-19 上午11:12:56 zhengdd Exp $
 */
@SuppressWarnings("deprecation")
public abstract class BaseDaoiBatis {
	// 日志
    protected final Logger log = Logger.getLogger(this.getClass());
    
	protected int                batchSize = 500;

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }

    /**
     * 根据分页条件获取分页信息, 其中page参数目前默认采用SimplePage或其子类
     * 
     * @param <T>
     * @param page 分页信息
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
     * 不需要分页查出所有信息 (所以不需要查总数)
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
