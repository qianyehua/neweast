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
	 * ����id��ȡϵͳ����
	 */
    @Override
    public SystemFunction getSystemFunctionById(Long id) {
        return (SystemFunction) this.getSqlMapClientTemplate().queryForObject(
            SQLMAP_SPACE + "getSystemFunctionById", id);
    }
    /**
     * ����pid��ȡ�Ӳ˵��б�
     * @author wm
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getSystemFunctionByPid(Long pid) {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getSystemFunctionByPid",
	            pid);
	}
	
	/**
     * ȡ�����еĹ�����Ϣ
     * @author wm
     * @return
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getAllSystemFunction() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getAllSystemFunction");
	}
	
	/**
	 * ����pid��ȡϵͳ���ܲ˵�
	 * @author wm
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemFunction> getSystemFunctionMenusByPid(Long pid) {
		return this.getSqlMapClientTemplate().queryForList(
				SQLMAP_SPACE + "getSystemFunctionMenusByPid", pid);
	}

	/**
	 * ���ϵͳ����
	 * @author wm
	 */
	@Override
	public Long addSystemFunction(SystemFunction systemFunction) {
		return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insertSystemFunction",
	            systemFunction);
	}
	
	/**
	 * �޸�ϵͳ����
	 * @author wm
	 */
	@Override
	public Integer editSystemFunction(SystemFunction systemFunction) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateSystemFunction",
	            systemFunction);
	}
	
	/**
	 * ɾ��ϵͳ����
	 * @author wm
	 */
	@Override
	public Integer removeSystemFunction(SystemFunction systemFunction) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "deleteSystemFunction",
	            systemFunction);
	}
	/**
	 * ��ȡϵͳ������
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
