package com.skyjoo.neweast.biz.account.domain;

import java.io.Serializable;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;

public class UserAccountCreditLevelResult extends DomainBase implements Serializable {

    private static final long       serialVersionUID = -1522453478808114079L;

    private List<UserAccountCreditLevel> list;

    public void setList(List<UserAccountCreditLevel> list) {
        this.list = list;
    }

    public List<UserAccountCreditLevel> getList() {
        return list;
    }
}
