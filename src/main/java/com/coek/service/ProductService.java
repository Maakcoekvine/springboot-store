package com.coek.service;

import com.coek.domain.Product;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 13:27:50
 */
public interface ProductService {


    /**
     * 获取热销商品
     * @return
     */
    List<Product> getHotList();

    /**
     * 获取最新产品
     * @return
     */
    List<Product> getLatestList();

    Product findProductById(Integer id);
}
