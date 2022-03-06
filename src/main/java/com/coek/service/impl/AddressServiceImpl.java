package com.coek.service.impl;

import com.coek.domain.Address;
import com.coek.domain.District;
import com.coek.mapper.AddressMapper;
import com.coek.mapper.DistinctMapper;
import com.coek.service.AddressService;
import com.coek.service.exception.AccessDeniedException;
import com.coek.service.exception.AddressNotFoundException;
import com.coek.service.exception.InsertException;
import com.coek.service.exception.UserAddressCountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 17:15:49
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistinctMapper distinctMapper;

   // @Transactional
    @Override
    public void createAddress(Address address, String username, Integer uid) {

        Integer counts = addressMapper.selectCountAddress(uid);
        if (counts>=20){

            throw new UserAddressCountException("用户收货地址已超过20条");
        }

        String AreaName = distinctMapper.findNameByCode(address.getAreaCode());
        String cityName = distinctMapper.findNameByCode(address.getCityCode());
        String provinceName = distinctMapper.findNameByCode(address.getProvinceCode());

        //数据装配
        address.setAreaName(AreaName);
        address.setCityName(cityName);
        address.setProvinceName(provinceName);
        Integer isDefault=counts==0?1:0;
        address.setUid(uid);
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        Integer rows = addressMapper.createAddress(address);
        if (rows!=1){

            throw new InsertException("服务器出现异常");
        }
    }

    @Override
    public List<Address> selectAddressList(Integer uid) {

        List<Address> addressList = addressMapper.getAddressListByUid(uid);
        return addressList;
    }

   // @Transactional
    @Override
    public void changeDefault(Integer uid, Integer aid, String username) {

        //查看当前地址是否存在
        Address result = addressMapper.selectAddressByAid(aid);
        if (null==result){

            throw new AddressNotFoundException("当前收货地址不存在");
        }

        if (!uid.equals(result.getUid())){

            throw new AccessDeniedException("非法数据访问");
        }

        //将当前uid下的所有默认收货地址全改为0
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        if (rows<1){

            throw new InsertException("数据修改异常");
        }

        //将当前aid的收货地址改为默认收货地址
        Integer rows2 = addressMapper.updateDefaultByAid(aid,username,new Date());
        if (rows2!=1){

            throw new InsertException("数据修改异常");
        }
        System.out.println("成功修改了默认收货地址");
    }


   // @Transactional
    @Override
    public void deleteAddress(Integer aid,Integer uid) {
        //查询要删除的地址是否存在
        Address result = addressMapper.selectAddressByAid(aid);
        if (null==result){

            throw new AddressNotFoundException("地址不存在");
        }

        //操作不符
        if (!uid.equals(result.getUid())){

            throw new AccessDeniedException("非法访问");
        }

        Integer rows = addressMapper.deleteByAid(aid);
        if (rows!=1){

            throw new InsertException("删除数据异常");
        }

        System.out.println("成功删除收货地址");
    }
}
