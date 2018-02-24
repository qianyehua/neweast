package com.skyjoo.neweast.biz.common.page;

import java.util.Collection;

/**
 * ����JEECMS�еķ�ҳPaginable�ӿ�, �����˻�÷�ҳ���ݵ�getDate()����
 * 
 * @author zhengdd
 * @version $Id: Paginable.java,v 0.1 2010-3-25 ����10:11:16 zhengdd Exp $
 * @param <T>
 * @see com.ponyjava.common.page.Paginable
 */
public interface Paginable<T> {
    
    /**
     * �ܼ�¼��
     * 
     * @return int
     */
    public int getTotalCount();

    /**
     * ��ҳ��
     * 
     * @return int
     */
    public int getTotalPage();

    /**
     * ÿҳ��¼��
     * 
     * @return int
     */
    public int getPageSize();

    /**
     * ��ǰҳ��
     * 
     * @return int
     */
    public int getPageNo();

    /**
     * �Ƿ��һҳ
     * 
     * @return int
     */
    public boolean isFirstPage();

    /**
     * �Ƿ����һҳ
     * 
     * @return int
     */
    public boolean isLastPage();

    /**
     * ������ҳ��ҳ��
     * 
     * @return int
     */
    public int getNextPage();

    /**
     * ������ҳ��ҳ��
     * 
     * @return int
     */
    public int getPrePage();

    /**
     * ȡ�õ�ǰҳ��ʾ�������ʼ��� (1-based)��
     * 
     * @return int ��ʼ���
     */
    public int getBeginIndex();

    /**
     * ȡ�õ�ǰҳ��ʾ��ĩ����� (1-based)��
     * 
     * @return int ĩ�����
     */
    public int getEndIndex();
    
    /**
     * ȡ�÷�ҳ����
     * 
     * @return Collection<T> ��ҳ����
     */
    public Collection<T> getData();
    
}
