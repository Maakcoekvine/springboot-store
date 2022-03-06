package com.coek.mapper;

import com.coek.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 16:57:22
 */
public interface AddressMapper {

    /**添加收货地址*/
    Integer createAddress(Address address);

    /**
     * 查询用户收货地址条数，不得多于20条
     */
    Integer selectCountAddress(Integer uid);

    /**
     * 根据用户的id查询其所有收货地址
     * @param uid   用户id
     * @return      用户所有收货地址
     */
    List<Address> getAddressListByUid(Integer uid);


    /**
     * 根据aid来查询是否存在当前收货地址（设置默认收货地址、删除地址，修改地址用）
     * @param aid
     * @return
     */
    Address selectAddressByAid(Integer aid);

    /**
     * 根据uid来把当前的默认地址全设为0
     * @param uid
     * @return
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 根据aid来设置默认收货地址
     * @param aid
     * @return
     */
    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("username") String username,
                               @Param("updateTime") Date updateTime);


    /**
     * 根据aid来删除用户收货地址
     * @param aid 收货地址
     * @return
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据aid查找收货地址
     * @param aid
     * @return
     */
    Address getByAid(Integer aid);
}
