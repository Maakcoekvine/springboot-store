package com.coek.service;

import com.coek.domain.District;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 19:40:02
 */
public interface DistrictService {

    /**
     * 查询所有省
     */
    List<District> getAllParent(String parent);
}
