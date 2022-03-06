package com.coek.service;

import com.coek.domain.Order;
import com.coek.vo.CartVO;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 12:33:06
 */
public interface OrderService {

    Order createOrder(Integer[] cids,Integer aid,String username,Integer uid);
}
