package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;

public interface ArtPropertyValueService{
	/**
	 * ��ȡ����Ʒ����ֵ
	 * @return List
	 */
	public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId);
}
