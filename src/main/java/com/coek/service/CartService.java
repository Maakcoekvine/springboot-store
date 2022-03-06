package com.coek.service;

import com.coek.vo.CartVO;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 22:10:58
 */
public interface CartService {

    /**
     * 添加到购物车
     * @param uid 用户id
     * @param pid 商品id
     * @param num 商品数量
     * @param price 商品价格
     */
    void addToCart(Integer uid,
                   Integer pid,
                   Integer num,
                   Long price,
                   String usernmae);


    /**
     * 展示用户购物车
     * @param uid 用户id
     * @return
     */
    List<CartVO> showCartList(Integer uid);

    /**
     * 增加购物车中商品数量
     * @param cid 购物车中某条记录
     * @return
     */
    void addProductNum(Integer cid,Integer uid);

    /**
     * 减少购物车中商品数量
     * @param cid 购物车中某条记录
     * @param uid 用户id
     */
    void reduceProductNum(Integer cid,Integer uid);

    /**
     * 查询购物车中需结算的商品
     * @param uid 用户id
     * @param cids  需结算购物车id
     * @return
     */
    List<CartVO> showSelectedProduct(Integer uid,Integer[] cids);

    /**
     * 根据cid删除购物车中的商品
     * @param cid
     */
    void deleteCartByCid(Integer cid,Integer uid);
}
