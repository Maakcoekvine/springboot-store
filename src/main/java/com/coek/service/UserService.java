package com.coek.service;

import com.coek.domain.User;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:07:25
 */

public interface UserService {

    /**用户注册*/
    void reg(User user);

    /**用户登录*/
    User login(User user);

    /**用户修改密码*/
    void updatePwd(User user,String newPassword);

    /**查询个人资料*/
    User findUserByUid(Integer uid);

    /**修改个人资料*/
    void updateUserInfo(User user);

    /**修改头像*/
    void updateUserAvatar(User user);
}
