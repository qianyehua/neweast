package com.skyjoo.neweast.biz.point.dao;

import java.util.List;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.UserPoint;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;

public interface UserPointDao {
    /**
     * 根据条件搜索
     * @param tradeAccount
     */
    public void list(UserPointQuery tradeAccount);

    /**
     * 根据account查询userPoint
     * @param account
     * @return
     */
    public UserPoint getUserPointByTradeAccount(String account);

    /**
     * 新增UserPoint
     * @param userPoint
     * @return
     */
    public Result<Void> add(UserPoint userPoint);

    /**
     * 修改UserPoint
     * @param userPoint
     * @return
     */
    public Result<Void> update(UserPoint userPoint);

    /**
     * 检查账户状态
     * @param account
     * @return
     */
    public int checkAccount(String account);
    //    public int insertCell(List<UserPoint> addList, List<UserPoint> upList);
}
