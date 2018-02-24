package com.skyjoo.neweast.biz.activity.domain;

import java.io.Serializable;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;

public class ActivityXArtResult extends DomainBase implements Serializable {
    private static final long serialVersionUID = -8432504740343862043L;
    
    private List<ActivityXArt> list;

    public void setList(List<ActivityXArt> list) {
        this.list = list;
    }

    public List<ActivityXArt> getList() {
        return list;
    }
}