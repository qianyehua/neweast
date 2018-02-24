package com.skyjoo.neweast.biz.point.service;

import java.util.List;

import com.skyjoo.neweast.biz.point.domain.ExcelCell;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;
import com.skyjoo.wudadao.greenbird.dto.PointChangeDTO;

public interface UserPointServer {
    /**
     * ����excel���ݱ༭
     * @param cell ��excel��Ԫ����
     */
    public List<PointChangeDTO> edit(List<ExcelCell> cell);

    /**
     * �û����ֲ�ѯ
     * @param account
     */
    public void list(UserPointQuery account);
    
    /**
     * ����˻�״̬
     * @param account
     * @return
     */
    public boolean checkAccount(String account);
}
