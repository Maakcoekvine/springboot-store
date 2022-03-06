package com.coek.service.impl;

import com.coek.domain.Address;
import com.coek.domain.Order;
import com.coek.domain.OrderItem;
import com.coek.mapper.AddressMapper;
import com.coek.mapper.CartMapper;
import com.coek.mapper.OrderItemMapper;
import com.coek.mapper.OrderMapper;
import com.coek.service.OrderService;
import com.coek.service.exception.InsertException;
import com.coek.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 12:35:49
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private CartMapper cartMapper;

    //@Transactional
    @Override
    public Order createOrder(Integer[] cids,Integer aid,String username,Integer uid) {

        //获取当前需要结算的商品
        List<CartVO> cartVOS = cartMapper.showSelectedList(uid, cids);
        Long totalPrice=0L;
        for (CartVO cartVO:cartVOS){
            //计算总价
            totalPrice+=cartVO.getPrice()*cartVO.getNum();
        }
        Date date=new Date();
        //根据前端传来的aid查找用户收货地址
        Address address = addressMapper.getByAid(aid);
        //数据装配
        Order order=new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        order.setPayTime(date);
        order.setOrderTime(date);
        order.setCreatedTime(date);
        order.setModifiedTime(date);
        order.setCreatedUser(username);
        order.setModifiedUser(username);
        Integer rows = orderMapper.createOrder(order);
        if (rows!=1){

            throw new InsertException("创建订单异常");
        }
        //数据装配
        /*for (CartVO cartVO:cartVOS){
            OrderItem ot=new OrderItem();
            ot.setNum(cartVO.getNum());
            ot.setPrice(cartVO.getPrice());
            ot.setImage(cartVO.getImage());
            ot.setPid(cartVO.getPid());
            ot.setOid(order.getOid());
            ot.setCreatedUser(username);
            ot.setModifiedUser(username);
            ot.setModifiedTime(date);
            ot.setCreatedTime(date);
            Integer rows2 = orderItemMapper.createOrderItem(ot);
            if (rows2!=1){

                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }

        }*/
        return order;
    }
}
