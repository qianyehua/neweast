package com.skyjoo.neweast.biz.common.page;

import java.util.List;

/**
 * ����JEECMS�еķ�ҳPagination��, ʵ����Paginable�ӿڵ�getDate()����
 *
 * @author zhengdd
 * @version $Id: Pagination.java,v 0.1 2010-3-25 ����10:34:35 zhengdd Exp $
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
     * ��ǰҳ������
     */
    private List<T> list;

    /**
     * ȡ�÷�ҳ����
     *
     * @return List<T> ��ҳ����
     */
    public List<T> getData() {
        return list;
    }

    /**
     * ���÷�ҳ����
     *
     * @param date ��ҳ����
     */
    public void setData(List<T> data) {
        this.list = data;
    }

}
