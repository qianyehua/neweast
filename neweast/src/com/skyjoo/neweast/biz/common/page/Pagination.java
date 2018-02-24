package com.skyjoo.neweast.biz.common.page;

import java.util.List;

/**
 * 来自JEECMS中的分页Pagination类, 实现了Paginable接口的getDate()方法
 *
 * @author zhengdd
 * @version $Id: Pagination.java,v 0.1 2010-3-25 上午10:34:35 zhengdd Exp $
 * @param T
 * @see com.ponyjava.common.page.Pagination
 */
public class Pagination<T> extends SimplePage<T> {

    private static final long serialVersionUID = 6398443093873035070L;

    public Pagination() {
    }

    public Pagination(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    @SuppressWarnings("unchecked")
    public Pagination(int pageNo, int pageSize, int totalCount, List list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 当前页的数据
     */
    private List<T> list;

    /**
     * 取得分页数据
     *
     * @return List<T> 分页数据
     */
    public List<T> getData() {
        return list;
    }

    /**
     * 设置分页数据
     *
     * @param date 分页数据
     */
    public void setData(List<T> data) {
        this.list = data;
    }

}
