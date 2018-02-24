package com.skyjoo.neweast.biz.datadic.dao;

import java.util.List;

import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;

/**
 * 字典数据Dao类
 * @author lxh
 * @version 2014-11-3 上午10:48:43
 */
public interface CommDatadicDAO {

	/**
	 * 获取所有的字典数据
	 * @return
	 */
	public List<CommDatadic> getAllCommDatadics();

}
