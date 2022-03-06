package com.coek;

import com.coek.domain.Order;
import com.coek.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 11:25:26
 */
@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void test01(){
        Order order=new Order();
        order.setUid(3);
        order.setRecvName("M先生");
        order.setRecvPhone("124342342");
        order.setRecvProvince("内蒙古自治区");
        order.setRecvCity("赤峰市");
        order.setRecvArea("巴林右旗");
        order.setRecvAddress("指定没好果子吃街");
        order.setTotalPrice(199L);
        order.setStatus(0);
        order.setOrderTime(new Date());
        order.setCreatedUser("管理员");
        order.setCreatedTime(new Date());
        order.setModifiedTime(new Date());
        order.setModifiedUser("管理员");
        orderMapper.createOrder(order);
    }
}
