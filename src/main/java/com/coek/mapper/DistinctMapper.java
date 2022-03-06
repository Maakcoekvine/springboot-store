package com.coek.mapper;

import com.coek.domain.District;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 18:14:22
 */
public interface DistinctMapper {

    /**获取省列表*/
    List<District> getByParent(String getByParent);

    /***
     * 获取市区列表，通过code
     */
    String findNameByCode(String code);
}
