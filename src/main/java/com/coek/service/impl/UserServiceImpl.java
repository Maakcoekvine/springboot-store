package com.coek.service.impl;

import com.coek.domain.User;
import com.coek.mapper.UserMapper;
import com.coek.service.UserService;
import com.coek.service.exception.InsertException;
import com.coek.service.exception.UserNameNotExistException;
import com.coek.service.exception.UserNameOccupyException;
import com.coek.service.exception.UserPwdNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:08:34
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    //@Transactional
    @Override
    public void reg(User user) throws RuntimeException {

        User result = userMapper.findByUserName(user.getUsername());
        //不为null，当前用户名已被占用
        if (null != result) {
            throw new UserNameOccupyException("当前用户名已经存在");
        }
        //未加密的密码
        String oldPwd = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //MD5加密
        String newPwd = getM5Pwd(oldPwd, salt);

        user.setPassword(newPwd);
        user.setSalt(salt);
        user.setIsDelete(0);
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());

        //注册
        Integer rows = userMapper.userRegister(user);
        if (rows != 1) {
            //数据库异常
            throw new InsertException("未知错误..");
        }

    }

    /**
     * 用户登录
     *
     * @param user 前端用户参数
     * @return
     */
    @Override
    public User login(User user) throws RuntimeException{

        User result = userMapper.findByUserName(user.getUsername());
        //当前用户名不存在
        if (null == result || result.getIsDelete() == 1) {

            throw new UserNameNotExistException("当前用户不存在");
        }
        //获取未加密密码
        String oldPwd = user.getPassword();
        //获取盐值
        String salt = result.getSalt();
        //加密
        String newPwd = getM5Pwd(oldPwd, salt);
        //对比
        if (!newPwd.equals(result.getPassword())) {

            throw new UserPwdNotMatchException("密码错误");
        }


        //装配信息放入session域
        User u = new User();
        u.setUsername(result.getUsername());
        u.setUid(result.getUid());
        u.setAvatar(result.getAvatar());

        return u;
    }

    /**
     * 修改密码
     */
    //@Transactional
    @Override
    public void updatePwd(User user, String newPassword) {

        String oldPassword = user.getPassword();
        Integer uid = user.getUid();

        User result = userMapper.findByUid(uid);
        //盐值
        String salt = result.getSalt();
        //旧密码比对
        if (!result.getPassword().equals(getM5Pwd(oldPassword, salt))) {
            throw new UserPwdNotMatchException("原密码输入不正确");
        }

        String newMd5Pwd = getM5Pwd(newPassword, salt);
        //数据装配
        result.setPassword(newMd5Pwd);
        result.setModifiedUser(user.getUsername());
        result.setModifiedTime(new Date());

        Integer rows = userMapper.updateUserPwd(result);
        if (1 != rows) {
            throw new InsertException("数据更新异常");
        }

    }

    /**
     * 查询个人资料
     */
    @Override
    public User findUserByUid(Integer uid) {

        User result = userMapper.findByUid(uid);
        if (null == result | result.getIsDelete() == 1) {

            throw new UserNameNotExistException("用户数据不存在");
        }

        //封装给前端展示的数据
        User user = new User();
        user.setUid(uid);
        user.setEmail(result.getEmail());
        user.setPhone(result.getPhone());
        user.setGender(result.getGender());
        user.setUsername(result.getUsername());

        return user;
    }

    /**
     * 更新个人资料
     */
    //@Transactional
    @Override
    public void updateUserInfo(User user) {

        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateUserInfo(user);
        if (1 != rows) {
            throw new InsertException("更新个人资料出现异常");
        }

    }

    /**
     * 上传头像
     */
    @Override
    public void updateUserAvatar(User user) {

        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateAvatar(user);
        if (1 != rows) {

            throw new InsertException("上传头像出现未知异常");
        }


    }

    /**
     * md5加密工具
     *
     * @param pwd  未加密的密码
     * @param salt 盐值
     * @return 加密之后的密码
     */
    private String getM5Pwd(String pwd, String salt) {

        for (int i = 0; i < 3; i++) {
            pwd = DigestUtils.md5DigestAsHex((salt + pwd + salt).getBytes()).toUpperCase();
        }
        return pwd;
    }
}




