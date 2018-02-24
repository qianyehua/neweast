package com.skyjoo.neweast.biz.artise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.artise.dao.ArtiseRecordDAO;
import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;
import com.skyjoo.neweast.biz.artise.service.ArtiseRecordService;

@Service(value="artiseRecordService")
public class ArtiseRecordServiceImpl implements ArtiseRecordService {

    @Autowired
    private ArtiseRecordDAO  artiseRecordDAO;
	
	
    @Override
    public List<ArtiseRecord> getRecordList(Artise artise) {
        return artiseRecordDAO.getRecordList(artise);
    }


}
