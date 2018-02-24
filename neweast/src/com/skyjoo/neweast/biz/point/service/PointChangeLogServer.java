package com.skyjoo.neweast.biz.point.service;

import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;

public interface PointChangeLogServer {
    /**
     * 根据条件查询积分变更日志
     * @param pclq
     */
    public void list(PointChangeLogQuery pclq);
}
