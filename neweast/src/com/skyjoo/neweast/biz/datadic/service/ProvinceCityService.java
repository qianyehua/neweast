package com.skyjoo.neweast.biz.datadic.service;

import java.util.List;

import com.skyjoo.neweast.biz.datadic.domain.SimpleCity;

public interface ProvinceCityService {

    /**
     * ���ؼ���ʡ�ݺͳ��й�ϵ
     * @return
     */
    public List<SimpleCity> getSimpleProvinceCityList();

    /**
     * ��ȡ��������
     * @param province
     * @param city
     * @param suffix ��׺
     * @return
     */
    public String getProvinceCityName(String province, String city, String... suffix);
}
