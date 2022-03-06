package com.coek.service.impl;

import com.coek.domain.Product;
import com.coek.mapper.ProductMapper;
import com.coek.service.ProductService;
import com.coek.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 13:29:34
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getHotList() {
        List<Product> productList = productMapper.getHotList();

        //过滤不必要数据
        for (Product product  :productList){

            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return productList;
    }


    @Override
    public List<Product> getLatestList() {
        List<Product> productList = productMapper.getLatestList();

        //过滤不必要数据
        for (Product product  :productList){

            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return productList;
    }

    @Override
    public Product findProductById(Integer id) {
        Product product = productMapper.findById(id);
        if (null==product){

            throw new ProductNotFoundException("抱歉,该商品不存在");
        }

        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        return product;
    }
}
