package com.coek;

import com.coek.mapper.CartMapper;
import com.coek.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-27 18:21:01
 */
@SpringBootTest
public class CartTest {

    @Autowired
    private CartMapper cartMapper;
    @Test
    public void test01(){
        List<CartVO> cartVOS = cartMapper.showCartList(2);
        for (CartVO cartVO :cartVOS){
            System.out.println(cartVO);
        }
    }
    @Test
    public void test02(){
        Integer integer = cartMapper.addNum(7, new Date());
        System.out.println(integer);

    }

    @Test
    public void test03(){

        Integer integer = cartMapper.reduceNum(8, new Date());
        System.out.println(integer);
    }

    @Test
    public void test04(){

        Integer[] cids={1,3,8};
        List<CartVO> cartVOS = cartMapper.showSelectedList(3, cids);
        for (CartVO cartVO:cartVOS){
            System.out.println(cartVO);
        }
    }
}
