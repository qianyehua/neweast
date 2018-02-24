package com.skyjoo.neweast.biz.point.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;

public interface PointConfigServer {
    /**
     *  查询 
     * @param query
     */
    public void list(PointGainRuleQuery query);

    /*
     * 各渠道同步 总有效次数 每日有效次数 登录加成周期
     */
    public void updateAll(PointGainRule pointGainRule);

    /**
     * 修改
     * @param rule
     * @return
     */
    public Result<Void> edit(PointGainRule rule);

    /**
     * 新增
     * @param rule
     * @return
     */
    public Result<Void> add(PointGainRule rule);

    /**
     * 根据事件类型、渠道查询pointGainRule
     * @param type
     * @param chann
     * @return
     */
    public PointGainRule getPointGainRuleByType(String type, String chann);

    /**
     * 获取同步参数
     * @return
     */
    public PointGainRule getThreeSynparameter(String type);
}
