package com.skyjoo.neweast.biz.point.dao;

import java.util.List;
import java.util.Map;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;

public interface PointDao {
    /**
     * 根据条件查询
     * @param query
     */
    public void getPaginatePoint(PointGainRuleQuery query);

    /**
     * 修改规则
     * @param rule
     * @return
     */

    public Result<Void> edit(PointGainRule rule);

    /**根据id查询pointGainRule
     * 
     * @param map
     * @return
     */
    public PointGainRule getPointGainRuleByType(Map<String, String> map);

    /**
     * 添加规则
     * @param rule
     * @return
     */
    public Result<Void> add(PointGainRule rule);

    /**
     * 三个参数同步
     * @param eventType
     * @return
     */
    public List<PointGainRule> updateAll(String eventType);
}
