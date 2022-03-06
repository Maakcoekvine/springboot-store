package com.coek.controller;

import com.coek.service.CartService;
import com.coek.utils.JsonResult;
import com.coek.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 22:34:34
 */
@RestController
@RequestMapping("cart")
public class CartController extends BaseController{
    @Autowired
    private CartService cartService;

    @PostMapping("add")
    public JsonResult addCart(@RequestParam("pid") Integer pid,
                              @RequestParam("price") Long price,
                              @RequestParam("num") Integer num,
                              HttpSession session){

        Integer uid=getUserId(session);
        String username=getUserName(session);
        cartService.addToCart(uid,pid,num,price,username);
        System.out.println("----------添加购物车----------");
        return new JsonResult(OK);
    }

    @GetMapping("list")
    public JsonResult showCartList(HttpSession session){

        Integer uid = getUserId(session);
        List<CartVO> data = cartService.showCartList(uid);
        System.out.println("----------展现购物车数据----------");
        return new JsonResult(OK,data);
    }

    @PostMapping("addNum")
    public JsonResult addNum(@RequestParam("cid") Integer cid,
                             HttpSession session){

        Integer uid = getUserId(session);
        cartService.addProductNum(cid,uid);
        System.out.println("----------添加购物车中单个商品数量----------");
        return new JsonResult(OK);
    }

    @PostMapping("reduceNum")
    public JsonResult reduceNum(@RequestParam("cid") Integer cid,
                                HttpSession session){

        Integer uid = getUserId(session);
        cartService.reduceProductNum(cid,uid);
        System.out.println("----------减少购物车中单个商品数量----------");
        return new JsonResult(OK);
    }

    @GetMapping("showSelectedList")
    public JsonResult showSelectedList(@RequestParam("cids") Integer[]cids,
                                       HttpSession session){
        Integer uid = getUserId(session);
        List<CartVO> data = cartService.showSelectedProduct(uid, cids);
        System.out.println("----------进入确定订单界面----------");
        return new JsonResult(OK,data);
    }

    @PostMapping("delete")
    public JsonResult deleteCart(Integer cid,HttpSession session){

        Integer uid = getUserId(session);
        cartService.deleteCartByCid(cid,uid);
        System.out.println("----------删除购物车中商品" +
                "----------");
        return new JsonResult(OK);
    }
}
