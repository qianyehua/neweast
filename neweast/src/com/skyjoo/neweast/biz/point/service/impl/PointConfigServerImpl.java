package com.skyjoo.neweast.biz.point.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.point.dao.PointDao;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;
import com.skyjoo.neweast.biz.point.service.PointConfigServer;

@Service
public class PointConfigServerImpl extends BaseManager implements PointConfigServer {
    @Autowired
    private PointDao pointDao;

    @Override
    public void list(PointGainRuleQuery query) {
        pointDao.getPaginatePoint(query);
    }

    @Override
    public Result<Void> edit(PointGainRule rule) {
        return pointDao.edit(rule);
    }

    @Override
    public PointGainRule getPointGainRuleByType(String type, String chann) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("chann", chann);
        return pointDao.getPointGainRuleByType(map);
    }

    @Override
    public Result<Void> add(PointGainRule rule) {
        return pointDao.add(rule);
    }

    @Override
    public void updateAll(PointGainRule pointGainRule) {
        List<PointGainRule> rules = pointDao.updateAll(pointGainRule.getEventType());
        for (PointGainRule rule : rules) {
            rule.setTotalTimes(pointGainRule.getTotalTimes());
            rule.setDailyTimes(pointGainRule.getDailyTimes());
            rule.setLoginPeriod(pointGainRule.getLoginPeriod());
            pointDao.edit(rule);
        }
    }

    @Override
    public PointGainRule getThreeSynparameter(String type) {
        PointGainRule rule = new PointGainRule();
        List<PointGainRule> rules = pointDao.updateAll(type);
        if (rules.size() > 0) {
            rule.setTotalTimes(rules.get(0).getTotalTimes());
            rule.setDailyTimes(rules.get(0).getDailyTimes());
            rule.setLoginPeriod(rules.get(0).getLoginPeriod());
        }
        return rule;
    }

}
