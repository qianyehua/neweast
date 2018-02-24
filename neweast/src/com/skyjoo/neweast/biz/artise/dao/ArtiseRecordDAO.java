package com.skyjoo.neweast.biz.artise.dao;

import java.util.List;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;

public interface ArtiseRecordDAO {
    
    /**
     * 获取履历列表
     * @param artise
     * @return
     */
    public List<ArtiseRecord> getRecordList(Artise artise);
	

}
