package com.skyjoo.neweast.biz.point.service;

import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;

public interface PointChangeLogServer {
    /**
     * ����������ѯ���ֱ����־
     * @param pclq
     */
    public void list(PointChangeLogQuery pclq);
}
