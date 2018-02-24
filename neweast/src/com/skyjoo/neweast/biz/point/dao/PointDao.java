package com.skyjoo.neweast.biz.point.dao;

import java.util.List;
import java.util.Map;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;

public interface PointDao {
    /**
     * ����������ѯ
     * @param query
     */
    public void getPaginatePoint(PointGainRuleQuery query);

    /**
     * �޸Ĺ���
     * @param rule
     * @return
     */

    public Result<Void> edit(PointGainRule rule);

    /**����id��ѯpointGainRule
     * 
     * @param map
     * @return
     */
    public PointGainRule getPointGainRuleByType(Map<String, String> map);

    /**
     * ��ӹ���
     * @param rule
     * @return
     */
    public Result<Void> add(PointGainRule rule);

    /**
     * ��������ͬ��
     * @param eventType
     * @return
     */
    public List<PointGainRule> updateAll(String eventType);
}
