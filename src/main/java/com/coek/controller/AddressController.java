package com.coek.controller;

import com.coek.domain.Address;
import com.coek.domain.District;
import com.coek.service.AddressService;
import com.coek.service.DistrictService;
import com.coek.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 17:42:37
 */
@RestController
@RequestMapping("address")
public class AddressController extends BaseController{
    @Autowired
    private AddressService addressService;



    /**
     * 添加收货地址
     */

    @PostMapping("createUserAddress")
    public JsonResult createUserAddress(Address address, HttpSession session){

        Integer uid=getUserId(session);
        String username=getUserName(session);
        addressService.createAddress(address,username,uid);
        return new JsonResult(OK);
    }

    /**
     * 查询用户所有收货地址
     * @param session
     * @return
     */
    @GetMapping("getList")
    public JsonResult getAddressList(HttpSession session){

        Integer uid=getUserId(session);
        List<Address> addressList = addressService.selectAddressList(uid);
        return  new JsonResult(OK,addressList);
    }

    /**
     * 修改用户默认收货地址
     * @param session
     * @param aid     需设置为默认地址的aid值
     * @return
     */
    @PostMapping("{aid}/set_default")
    public JsonResult setDefaultAddress(HttpSession session,
                                        @PathVariable("aid") Integer aid){

        Integer uid=getUserId(session);
        String username=getUserName(session);
        addressService.changeDefault(uid,aid,username);
        return new JsonResult(OK);
    }

    /**
     * 删除用户收货地址
     * @param aid 收货地址id
     * @param session
     * @return
     */
    @PostMapping("{aid}/delete")
    public JsonResult deleteAddress(@PathVariable("aid") Integer aid,
                                    HttpSession session){

        Integer uid=getUserId(session);
        addressService.deleteAddress(aid,uid);
        return new JsonResult(OK);
    }
}

