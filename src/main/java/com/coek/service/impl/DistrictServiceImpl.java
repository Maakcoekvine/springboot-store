package com.coek.service.impl;

import com.coek.domain.District;
import com.coek.mapper.DistinctMapper;
import com.coek.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 19:48:10
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistinctMapper distinctMapper;
    @Override
    public List<District> getAllParent(String parent) {
        List<District> data = distinctMapper.getByParent(parent);
        return data;
    }
}
