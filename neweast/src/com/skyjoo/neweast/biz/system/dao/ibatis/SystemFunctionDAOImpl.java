package com.skyjoo.neweast.biz.system.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.system.dao.SystemFunctionDAO;
import com.skyjoo.neweast.biz.system.domain.SystemFunction;

@Repository
@SuppressWarnings({"deprecation" })
public class SystemFunctionDAOImpl extends BaseDaoiBatis implements SystemFunctionDAO {

	private static String SQLMAP_SPACE = "SYSTEM_FUNCTION.";

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getSystemFunctionsByRoleIDs(List<Long> roleIDs) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getSystemFunctionsByRoleIDs", roleIDs);
	}
	/**
	 * 根据id获取系统功能
	 */
    @Override
    public SystemFunction getSystemFunctionById(Long id) {
        return (SystemFunction) this.getSqlMapClientTemplate().queryForObject(
            SQLMAP_SPACE + "getSystemFunctionById", id);
    }
    /**
     * 根据pid获取子菜单列表
     * @author wm
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getSystemFunctionByPid(Long pid) {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getSystemFunctionByPid",
	            pid);
	}
	
	/**
     * 取得所有的功能信息
     * @author wm
     * @return
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getAllSystemFunction() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getAllSystemFunction");
	}
	
	/**
	 * 根据pid获取系统功能菜单
	 * @author wm
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getSystemFunctionMenusByPid(Long pid) {
		return this.getSqlMapClientTemplate().queryForList(
				SQLMAP_SPACE + "getSystemFunctionMenusByPid", pid);
	}

	/**
	 * 添加系统功能
	 * @author wm
	 */
	@Override
	public Long addSystemFunction(SystemFunction systemFunction) {
		return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insertSystemFunction",
	            systemFunction);
	}
	
	/**
	 * 修改系统功能
	 * @author wm
	 */
	@Override
	public Integer editSystemFunction(SystemFunction systemFunction) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateSystemFunction",
	            systemFunction);
	}
	
	/**
	 * 删除系统功能
	 * @author wm
	 */
	@Override
	public Integer removeSystemFunction(SystemFunction systemFunction) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "deleteSystemFunction",
	            systemFunction);
	}
	/**
	 * 获取系统功能数
	 * @author wm
	 */
	@Override
	public Integer getFunctionCount() {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				SQLMAP_SPACE + "getFunctionCount");
	}

	@Override
	public Integer getFunCountInFunRose(Long funId) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "getFunCountInFunRose",funId);
	}
	@Override
	public Long getParentId(Long id) {
		return (Long) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"getParentId", id);
	}

}
