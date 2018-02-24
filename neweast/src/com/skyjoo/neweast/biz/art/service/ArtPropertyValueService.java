package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;

public interface ArtPropertyValueService{
	/**
	 * 获取艺术品属性值
	 * @return List
	 */
	public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId);
}
