package com.coek.mapper;

import com.coek.domain.User;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-20 15:45:24
 */
public interface UserMapper {

    /**登录验证通过名字查询*/
    User findByUserName(String username);

    /**用户注册*/
    Integer userRegister(User user);

    /**查找个人资料*/
    User findByUid(Integer uid);

    /**修改密码*/
    Integer updateUserPwd(User user);

    /**修改个人资料*/
    Integer updateUserInfo(User user);

    /**上传头像*/
    Integer updateAvatar(User user);
}
