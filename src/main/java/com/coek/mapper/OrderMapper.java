package com.coek.mapper;

import com.coek.domain.Order;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 11:19:12
 */
public interface OrderMapper {

    /**
     * 创建订单
     * @param order
     * @return
     */
    Integer createOrder(Order order);
}
