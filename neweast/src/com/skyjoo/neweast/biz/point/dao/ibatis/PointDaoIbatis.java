package com.skyjoo.neweast.biz.point.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.point.dao.PointDao;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;

@Repository
public class PointDaoIbatis extends BaseDaoiBatis implements PointDao {
	private static String SQLMAP_SPACE = "POINT_GAIN_RULE.";

	@Override
	public void getPaginatePoint(PointGainRuleQuery query) {
		this.paginate(query,SQLMAP_SPACE+"query");
	}

	@Override
	public Result<Void> edit(PointGainRule rule) {
		Result<Void> result = new Result<Void>(false);
		long inf = (long) this.getSqlMapClientTemplate().update(SQLMAP_SPACE+"update", rule);
		if (inf>0) {
			result.setSuccess(true);
		}
		return result;
	}

	@Override
	public PointGainRule getPointGainRuleByType(Map<String, String> map) {
		return (PointGainRule) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getPointGainRuleByType", map);
	}

	@Override
	public Result<Void> add(PointGainRule rule) {
		Result<Void> result = new Result<Void>(false);
		long inf = (long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE+"insert", rule);
		if (inf>0) {
			result.setSuccess(true);
		}
		return result;
	}

	@Override
	public List<PointGainRule> updateAll(String eventType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", eventType);
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getPointGainRuleByType", map);
	}

     
}
