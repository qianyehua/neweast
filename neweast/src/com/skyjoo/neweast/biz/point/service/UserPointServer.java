package com.skyjoo.neweast.biz.point.service;

import java.util.List;

import com.skyjoo.neweast.biz.point.domain.ExcelCell;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;
import com.skyjoo.wudadao.greenbird.dto.PointChangeDTO;

public interface UserPointServer {
    /**
     * 根据excel数据编辑
     * @param cell ：excel单元数据
     */
    public List<PointChangeDTO> edit(List<ExcelCell> cell);

    /**
     * 用户积分查询
     * @param account
     */
    public void list(UserPointQuery account);
    
    /**
     * 检查账户状态
     * @param account
     * @return
     */
    public boolean checkAccount(String account);
}
