package com.skyjoo.neweast.biz.datadic.service;

import java.util.List;

import com.skyjoo.neweast.biz.datadic.domain.SimpleCity;

public interface ProvinceCityService {

    /**
     * 返回简洁版省份和城市关系
     * @return
     */
    public List<SimpleCity> getSimpleProvinceCityList();

    /**
     * 获取城市名称
     * @param province
     * @param city
     * @param suffix 后缀
     * @return
     */
    public String getProvinceCityName(String province, String city, String... suffix);
}
