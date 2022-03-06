package com.coek.mapper;

import com.coek.domain.OrderItem;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 11:36:35
 */
public interface OrderItemMapper {

    /**
     * 创建ordderItem
     * @param orderItem
     * @return
     */
    Integer createOrderItem(OrderItem orderItem);
}
