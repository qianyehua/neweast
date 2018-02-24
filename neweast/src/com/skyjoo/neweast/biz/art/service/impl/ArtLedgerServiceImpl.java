package com.skyjoo.neweast.biz.art.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtLedgerDAO;
import com.skyjoo.neweast.biz.art.domain.ArtLedger;
import com.skyjoo.neweast.biz.art.service.ArtLedgerService;

@Service
public class ArtLedgerServiceImpl implements ArtLedgerService {
    
    @Autowired
    private ArtLedgerDAO artLedgerDAO;

    @Override
    public Long insertArtLedger(ArtLedger artLedger) {
        return artLedgerDAO.insertArtLedger(artLedger);
    }

    @Override
    public void updateArtLedger(ArtLedger artLedger) {
        artLedgerDAO.updateArtLedger(artLedger);
        
    }

    @Override
    public ArtLedger getArtLedgerById(Long artLedgerId) {
        return artLedgerDAO.getArtLedgerById(artLedgerId);
    }

}
