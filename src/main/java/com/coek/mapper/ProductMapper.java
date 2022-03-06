package com.coek.mapper;

import com.coek.domain.Product;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 13:12:41
 */
public interface ProductMapper {

    /**
     * 获取热销排行产品列表
     * @return 所有热销排行产品
     */
    List<Product> getHotList();


    /**
     * 获取新到好货产品列表
     * @return 所有最新上架产品列表
     */
    List<Product> getLatestList();

    /**
     * 根据产品id获取信息
     * @param id 产品id
     * @return 产品信息
     */
    Product findById(Integer id);
}
