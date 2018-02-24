package com.skyjoo.neweast.biz.point.dao;

import java.util.List;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.PointChangeLog;
import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;

public interface PointChangeLogDao {
    /**
     * ÃÌº”log
     * @param changeLog
     * @return
     */
//    public Result<Void> add(PointChangeLog changeLog);

    /**
     * ≤È—Ølog
     * @param pclq
     */
    public void list(PointChangeLogQuery pclq);

    //	public Integer insertLogByExcel(List<PointChangeLog> logs);
}
