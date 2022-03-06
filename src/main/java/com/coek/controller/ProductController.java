package com.coek.controller;

import com.coek.domain.Product;
import com.coek.service.ProductService;
import com.coek.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 13:36:44
 */
@RestController
@RequestMapping("product")
public class ProductController extends BaseController{
    @Autowired
    private ProductService productService;

    /**
     * 获取热销列表
     * @return
     */
    @RequestMapping("getHotList")
    public JsonResult getHotList(){

        List<Product> data = productService.getHotList();
        System.out.println("----------显示热销商品----------");
        return new JsonResult(OK,data);
    }

    @RequestMapping("getLatestList")
    public JsonResult getLatestList(){

        List<Product> data = productService.getLatestList();
        System.out.println("----------显示最新商品----------");
        return new JsonResult(OK,data);
    }

    @RequestMapping("getDetail")
    public JsonResult getDetail(@RequestParam("pid") Integer id){

        Product product = productService.findProductById(id);
        System.out.println("----------查询单个商品----------");
        return new JsonResult(OK,product);
    }
}
