package com.skyjoo.neweast.biz.artise.dao;

import java.util.List;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;

public interface ArtiseRecordDAO {
    
    /**
     * ��ȡ�����б�
     * @param artise
     * @return
     */
    public List<ArtiseRecord> getRecordList(Artise artise);
	

}
