package com.skyjoo.neweast.biz.point.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.point.dao.UserPointDao;
import com.skyjoo.neweast.biz.point.domain.ExcelCell;
import com.skyjoo.neweast.biz.point.domain.UserPoint;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;
import com.skyjoo.neweast.biz.point.enums.EnumOccurChannel;
import com.skyjoo.neweast.biz.point.enums.EnumPointChangeLog;
import com.skyjoo.neweast.biz.point.service.UserPointServer;
import com.skyjoo.wudadao.greenbird.dto.PointChangeDTO;
import com.skyjoo.wudadao.greenbird.interfaces.RemoteUserPointService;

@Service
public class UserPointServerImpl extends BaseManager implements UserPointServer {

    @Autowired
    private UserPointDao           userPointDao;

    @Autowired
    private RemoteUserPointService remoteUserPointService;

    @Override
    public List<PointChangeDTO>  edit(List<ExcelCell> cellList) {
        List<PointChangeDTO> list = new ArrayList<PointChangeDTO>();
        for (final ExcelCell cell : cellList) {
            PointChangeDTO pcd = new PointChangeDTO();
            pcd.setTradeAccount(cell.getTradeAccount());
            pcd.setPointType(EnumPointChangeLog.PRESENT.getValue());
            pcd.setOccurChannel(EnumOccurChannel.ONLINE_PC.getValue());
            pcd.setOccurTime(new Date());
            pcd.setRelateId("");
            pcd.setRelateObject("");
            pcd.setRelateAmount(0L);
            pcd.setPointAmount(cell.getAmount());
            pcd.setMemo(cell.getReason());
            list.add(pcd);
        }
        //调用青鸟远程服务
       return  remoteUserPointService.pointChange(list);
    }

    @Override
    public void list(UserPointQuery query) {
        userPointDao.list(query);
    }

    @Override
    public boolean checkAccount(String account) {
         if (userPointDao.checkAccount(account)>=1) {//返回的是正常或初始化的账户个数
            return true;
        }
        return false;
    }
}
