package com.coek.service.impl;

import com.coek.domain.Cart;
import com.coek.mapper.CartMapper;
import com.coek.mapper.ProductMapper;
import com.coek.service.CartService;
import com.coek.service.exception.AccessDeniedException;
import com.coek.service.exception.InsertException;
import com.coek.service.exception.ProductNotFoundException;
import com.coek.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 22:13:09
 */

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;



   // @Transactional
    @Override
    public void addToCart(Integer uid, Integer pid,Integer num,Long price,String usernmae) {

        /*
        首先
            1、查询用户的购物车中存在当前需要添加的商品
                1.1、直接添加数量
            2、不存在，添加到购物车
         */
        Date date=new Date();
        Cart result = cartMapper.findByPidAndUid(pid, uid);
        if (null==result){

            Cart c=new Cart();
            c.setUid(uid);
            c.setModifiedUser(usernmae);
            c.setModifiedTime(date);
            c.setCreatedUser(usernmae);
            c.setCreatedTime(date);
            c.setPrice(price);
            c.setPid(pid);
            c.setNum(num);
            Integer rows = cartMapper.addToCart(c);
            if (rows!=1){

                throw new InsertException("添加购物车发生未知异常");
            }
        }else{

            Integer rows = cartMapper.updateNum(num, pid, date,uid);
            if (rows!=1){

                throw new InsertException("添加购物车发生未知异常");
            }
        }
    }

    @Override
    public List<CartVO> showCartList(Integer uid) {

        List<CartVO> cartVOS = cartMapper.showCartList(uid);
        for (CartVO cartVO: cartVOS){
            //取出的数据如果有一个不是当前用户的，则报错
            if (!cartVO.getUid().equals(uid)){

                throw new AccessDeniedException("非法数据访问");
            }
        }

        return cartVOS;
    }

    //@Transactional
    @Override
    public void addProductNum(Integer cid,Integer uid) {

        Cart result = cartMapper.findByCid(cid);
        if (null==result){

            throw new ProductNotFoundException("当前商品不存在购物车中..");
        }
        if (!result.getUid().equals(uid)){

            throw new AccessDeniedException("非法访问");
        }

        Integer rows = cartMapper.addNum(cid, new Date());
        if (rows!=1){

            throw new InsertException("增加商品数量失败，请重试");
        }
    }

   // @Transactional
    @Override
    public void reduceProductNum(Integer cid, Integer uid) {

        Cart result = cartMapper.findByCid(cid);
        if (null==result){

            throw new ProductNotFoundException("当前商品不存在购物车中");
        }
        if (!result.getUid().equals(uid)){

            throw new AccessDeniedException("非法访问");
        }

        Integer rows = cartMapper.reduceNum(cid, new Date());
        if (rows!=1){

            throw new InsertException("减少商品数量失败，请重试");
        }
    }

    @Override
    public List<CartVO> showSelectedProduct(Integer uid, Integer[] cids) {
        List<CartVO> cartVOS = cartMapper.showSelectedList(uid, cids);

        for (CartVO cartVO:cartVOS){
            //取出的数据如果有一个不是当前用户的，则报错
            if (!cartVO.getUid().equals(uid)){

                throw new AccessDeniedException("非法数据访问");
            }
        }
        return cartVOS;
    }

    @Override
    public void deleteCartByCid(Integer cid,Integer uid) {
        Cart result = cartMapper.findByCid(cid);
        if (null==result){

            throw new ProductNotFoundException("当前商品不在购物车中");
        }
        if (!result.getUid().equals(uid)){

            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = cartMapper.deleteCart(cid);
        if (rows!=1){

            throw new InsertException("删除出现异常，请重试");
        }
    }
}
