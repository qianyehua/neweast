package com.skyjoo.neweast.biz.artise.service;

import java.util.List;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;

public interface ArtiseRecordService {


	/**
	 * 
	 * @param artise
	 * @return
	 */
	public List<ArtiseRecord> getRecordList(Artise artise);
	
}
