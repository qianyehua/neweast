package com.skyjoo.neweast.biz.trade.domain;

import java.io.Serializable;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;

public class TradeCommisionRateResult extends DomainBase implements Serializable {

    private static final long        serialVersionUID = -5407930047168139341L;

    private List<TradeCommisionRate> list;

    public void setList(List<TradeCommisionRate> list) {
        this.list = list;
    }

    public List<TradeCommisionRate> getList() {
        return list;
    }
}
