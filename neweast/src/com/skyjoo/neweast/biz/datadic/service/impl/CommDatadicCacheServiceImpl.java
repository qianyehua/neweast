package com.skyjoo.neweast.biz.datadic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.datadic.dao.CommDatadicDAO;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;

@Service
public class CommDatadicCacheServiceImpl extends BaseManager implements CommDatadicCacheService {

    private static Map<String, List<CommDatadic>> datadicMap = new HashMap<String, List<CommDatadic>>();

    @Autowired
    private CommDatadicDAO                        commDatadicDao;

    @PostConstruct
    public synchronized void init() {
        List<CommDatadic> datadicList = commDatadicDao.getAllCommDatadics();
        if (!datadicList.isEmpty()) {
            datadicMap.clear();
            for (CommDatadic commDatadic : datadicList) {
                String type = commDatadic.getGroupName();
                if (datadicMap.containsKey(type)) {
                    datadicMap.get(type).add(commDatadic);
                } else {
                    List<CommDatadic> datadics = new ArrayList<CommDatadic>();
                    datadics.add(commDatadic);
                    datadicMap.put(type, datadics);
                }
            }
        }
    }

    @Override
    public List<CommDatadic> getCommDatadicsByGroupName(String groupName) {
        if (StringUtil.isBlank(groupName) || !datadicMap.containsKey(groupName)) {
            return new ArrayList<CommDatadic>();
        }
        return datadicMap.get(groupName);
    }

    @Override
    public List<CommDatadic> getCommDatadicsByGroupName(EnumDatadicGroupName groupName) {
        if (groupName == null)
            return new ArrayList<CommDatadic>();
        ;
        return getCommDatadicsByGroupName(groupName.getGroupName());
    }
}
