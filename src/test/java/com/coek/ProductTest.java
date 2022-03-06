package com.coek;

import com.coek.domain.Cart;
import com.coek.domain.Product;
import com.coek.mapper.CartMapper;
import com.coek.mapper.ProductMapper;
import com.coek.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 20:30:15
 */
@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CartService cartService;


    @Autowired
    private CartMapper cartMapper;
    @Test
    public void test01(){
        Product product = productMapper.findById(10000017);
        System.out.println(product);
    }


    @Test
    public void test02(){

        Cart cart=new Cart();
        cart.setNum(2);
        cart.setUid(3);
        cart.setPid(10000021);
        cart.setPrice(5219l);
        cart.setCreatedTime(new Date());
        cart.setCreatedUser("管理员");
        cart.setModifiedTime(new Date());
        cart.setModifiedUser("管理员");
        cartMapper.addToCart(cart);
    }

    @Test
    public void test03(){
        //cartService.addToCart(3,10000021,4,99l,"管理员");
        cartService.addToCart(2,10000028,3,4939l,"Jack");
    }
}
