package com.coek.service;

import com.coek.domain.Address;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 17:14:06
 */

public interface AddressService {
    /***
     * 创建新的收货地址
     * @param address  地址信息
     * @param username 创建该地址的用户名
     * @param uid      创建该地址的用户id
     * @return
     */
    void createAddress(Address address,String username,Integer uid);

    /**
     * 根据用户id显示用户所有收货地址
     * @param uid 用户id
     * @return 用户收货地址列表
     */
    List<Address> selectAddressList(Integer  uid);

    /**
     * 修改默认收货地址
     * @param uid 当前用户id
     * @param aid 被设置为默认地址的收货地址
     * @param username 修改人
     */
    void changeDefault(Integer uid,Integer aid,String username);


    /**
     * 删除收货地址
     * @param aid 收货地址id
     */
    void deleteAddress(Integer aid,Integer uid);


}
