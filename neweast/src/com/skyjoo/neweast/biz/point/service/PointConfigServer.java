package com.skyjoo.neweast.biz.point.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;

public interface PointConfigServer {
    /**
     *  ��ѯ 
     * @param query
     */
    public void list(PointGainRuleQuery query);

    /*
     * ������ͬ�� ����Ч���� ÿ����Ч���� ��¼�ӳ�����
     */
    public void updateAll(PointGainRule pointGainRule);

    /**
     * �޸�
     * @param rule
     * @return
     */
    public Result<Void> edit(PointGainRule rule);

    /**
     * ����
     * @param rule
     * @return
     */
    public Result<Void> add(PointGainRule rule);

    /**
     * �����¼����͡�������ѯpointGainRule
     * @param type
     * @param chann
     * @return
     */
    public PointGainRule getPointGainRuleByType(String type, String chann);

    /**
     * ��ȡͬ������
     * @return
     */
    public PointGainRule getThreeSynparameter(String type);
}
