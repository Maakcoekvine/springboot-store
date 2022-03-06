package com.coek;

import com.coek.controller.BaseController;
import com.coek.domain.User;
import com.coek.mapper.UserMapper;
import com.coek.service.UserService;
import com.coek.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Date;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-20 16:04:02
 */
@SpringBootTest
@MapperScan("com.coek.mapper")
public class RegisterTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = userMapper.findByUserName("张三");
        System.out.println(user.toString());
    }


    @Test
    public void test02(){

        User u=new User();
        u.setUsername("test003");
        u.setPassword("123");
        try {
            userService.reg(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //登录测试

    @Test
    public void test03(){
        User u=new User();
        u.setUsername("test003");
        u.setPassword("123");
        User success = userService.login(u);
        System.out.println(success);
    }

    @Test
   public void test04(){

        User user=new User();
        user.setUid(4);
        user.setPassword("123");
        user.setModifiedUser("管理员");
        user.setModifiedTime(new Date());
        userMapper.updateUserPwd(user);
    }

    //查找个人资料
    @Test
    public void test05(){
        User result = userMapper.findByUid(4);
        System.out.println(result);
    }

    //修改密码
    @Test
    public void test06(){
        User user=new User();
        user.setUid(3);
        user.setUsername("管理员");
        user.setPassword("123");
        String newPWd="1234";
        userService.updatePwd(user,newPWd);
    }

    //修改个人资料
    @Test
    public void test07(){
        User user=new User();
        user.setUid(3);
        user.setEmail("123@qq.com");
        user.setPhone("5280272");
        user.setGender(0);
        user.setModifiedTime(new Date());
        user.setModifiedUser("管理员");
        userMapper.updateUserInfo(user);
    }

    @Test
    public void test08(){
        User user = userService.findUserByUid(3);
        System.out.println(user);
    }

    @Test
    public void test09(){
        User user =new User();
        user.setUid(2);
        user.setEmail("7777@qq.com");
        user.setPhone("5280271");
        user.setGender(0);
        user.setModifiedTime(new Date());
        user.setModifiedUser("管理员");
        userService.updateUserInfo(user);
    }

    @Test
    public void test10(){
        User user=new User();
        user.setUid(1);
        user.setModifiedUser("管理员");
        user.setModifiedTime(new Date());
        user.setAvatar("ADSFF-1SDDF-DFD-ADFAFD-");
        userMapper.updateAvatar(user);
    }
}
