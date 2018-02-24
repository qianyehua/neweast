package com.skyjoo.neweast.biz.point.dao;

import java.util.List;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.UserPoint;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;

public interface UserPointDao {
    /**
     * ������������
     * @param tradeAccount
     */
    public void list(UserPointQuery tradeAccount);

    /**
     * ����account��ѯuserPoint
     * @param account
     * @return
     */
    public UserPoint getUserPointByTradeAccount(String account);

    /**
     * ����UserPoint
     * @param userPoint
     * @return
     */
    public Result<Void> add(UserPoint userPoint);

    /**
     * �޸�UserPoint
     * @param userPoint
     * @return
     */
    public Result<Void> update(UserPoint userPoint);

    /**
     * ����˻�״̬
     * @param account
     * @return
     */
    public int checkAccount(String account);
    //    public int insertCell(List<UserPoint> addList, List<UserPoint> upList);
}
