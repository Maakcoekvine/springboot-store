package com.coek.controller;

import com.coek.domain.Order;
import com.coek.service.OrderService;
import com.coek.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 20:07:32
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController{
    @Autowired
    private OrderService orderService;

    @GetMapping("createOrder")
    public JsonResult createOrder(@Param("cids") Integer[] cids,
                                  @Param("aid") Integer aid,
                                  HttpSession session){

        Integer uid = getUserId(session);
        String userName = getUserName(session);
        Order data = orderService.createOrder(cids, aid, userName, uid);

        return new JsonResult(OK,data);

    }
}
