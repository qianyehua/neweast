package com.skyjoo.neweast.biz.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.system.dao.SystemFunctionDAO;
import com.skyjoo.neweast.biz.system.dao.SystemRoleDAO;
import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.domain.SystemRole;
import com.skyjoo.neweast.biz.system.service.UserFuncsCacheService;

@Service("userFuncsCacheService")
public class UserFuncsCacheServiceImpl extends BaseManager implements
		UserFuncsCacheService {
	
	private Map<String, Integer> url2IdMap = new HashMap<String, Integer>();
	
	private Long offset = 10000L;
	
	@Autowired
	private SystemRoleDAO systemRoleDAO;
	@Autowired
	private SystemFunctionDAO systemFunctionDAO;
	
	@PostConstruct
	private void init() {
		url2IdMap.clear();
		List<SystemFunction> all = systemFunctionDAO.getAllSystemFunction();
		for (SystemFunction function : all) {
			url2IdMap.put(function.getUrl(), (int)(function.getId() - this.offset));
		}
	}
	
	@Override
	public List<Integer> getUserFunctionIds(Long userId) {
		init();		
		List<Integer> userFunctions = new ArrayList<Integer>();
		List<SystemRole> roles = systemRoleDAO.getSystemRolesByUserID(userId);
		if(!CollectionUtils.isEmpty(roles)) {
			List<Long> roleIDs = new ArrayList<Long>();
			for (SystemRole systemRole : roles) {
				roleIDs.add(systemRole.getId());
			}
			List<SystemFunction> systemFunctions = systemFunctionDAO.getSystemFunctionsByRoleIDs(roleIDs);
			if(!CollectionUtils.isEmpty(systemFunctions)) {
				for (SystemFunction function : systemFunctions) {
					if(!StringUtil.isBlank(function.getUrl())) {
						userFunctions.add((int)(function.getId() - this.offset));
					}
				}
			}
		}
		return userFunctions;
	}
	
	@Override
	public Integer getFunctionOffsetId(String url) {
		if(url2IdMap.containsKey(url)) {
			return url2IdMap.get(url);
		}
		return null;
	}

	@Override
	public Long getOffset() {
		return this.offset;
	}

	@Override
	public Map<String, Integer> getFunctionMap() {
		return url2IdMap;
	}
	
	
}
