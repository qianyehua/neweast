package com.skyjoo.neweast.biz.art.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtLedgerDAO;
import com.skyjoo.neweast.biz.art.domain.ArtLedger;


@Repository
public class ArtLedgerDAOImpl implements ArtLedgerDAO {
    
    private static final String SQLMAP_SPACE = "ART_LEDGER.";
    
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    
    
    @SuppressWarnings("deprecation")
    @Override
    public Long insertArtLedger(ArtLedger artLedger) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"insertArtLedger",artLedger);
    }


    @SuppressWarnings("deprecation")
    @Override
    public void updateArtLedger(ArtLedger artLedger) {
        this.sqlMapClient.update(SQLMAP_SPACE + "updateArtLedger", artLedger);
    }


    @SuppressWarnings("deprecation")
    @Override
    public ArtLedger getArtLedgerById(Long artLedgerId) {
        return (ArtLedger) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtLedgerById",artLedgerId);
    }

}
