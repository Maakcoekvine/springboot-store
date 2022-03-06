package com.coek.controller;

import com.coek.controller.exception.*;
import com.coek.domain.User;
import com.coek.service.UserService;
import com.coek.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-20 16:13:08
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user 前端用户参数
     */
    @RequestMapping("reg")
    public JsonResult<Void> userReg(User user){

        System.out.println("----------用户注册----------");
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("login")
    public JsonResult userLogin(User user, HttpSession session){

        System.out.println("----------用户登录----------");
        User result = userService.login(user);
        //放入session
        session.setAttribute("uid",result.getUid());
        session.setAttribute("username",result.getUsername());



        return new JsonResult(OK);
    }

    /**
     * 修改密码
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param session
     * @return
     */
    @RequestMapping("updatePwd")
    public JsonResult userUpdatePwd(String oldPassword,String newPassword,HttpSession session){

        System.out.println("----------修改密码----------");
        Integer uid = getUserId(session);
        String userName = getUserName(session);
        //装配
        User user=new User();
        user.setUid(uid);
        user.setPassword(oldPassword);
        user.setUsername(userName);
        userService.updatePwd(user,newPassword);

        return new JsonResult(OK);
    }

    /**显示个人资料*/
    @RequestMapping("getInfo")
    public JsonResult<Void> getUserInfo(HttpSession session){

        System.out.println("----------显示个人资料----------");
        Integer uid = getUserId(session);
        User user = userService.findUserByUid(uid);

        return new JsonResult(OK,user);
    }

    /**修改个人资料*/
    @RequestMapping("updateInfo")
    public JsonResult updateInfo(User user,HttpSession session){

        System.out.println("----------修改个人资料----------");
        String username=getUserName(session);
        Integer uid=getUserId(session);

        user.setModifiedUser(username);
        user.setUid(uid);
        userService.updateUserInfo(user);

        return new JsonResult(OK);
    }

    /**上传头像*/
    //头像上传文件的大小
    //@Value("${spring.servlet.multipart.maxFileSize}")
    public int AVATAR_MAX_SIZE=10 * 1024 *1024;
    //允许上传头像的类型
    public  static final List<String> AVATAR_TYPES=new ArrayList<>();
    static{
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    @RequestMapping("updateAvatar")
    public JsonResult updateAvatar(@RequestParam("file") MultipartFile file, HttpSession session){

        if (file.isEmpty()){

            throw new FileEmptyException("上传的头像不能为空");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){

            throw new FileSizeException("不允许上传超过10MB的头像");
        }

        //头像文件类型
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)){

            throw new FileTypeException("上传的头像文件类型不符合");
        }

        //获取父路径
        String parent = session.getServletContext().getRealPath("upload");
        //创建保存头像的文件夹
        File dir=new File(parent);
        if (!dir.exists()){
            dir.mkdir();
        }

        //前端头像文件名
        String originalFilename = file.getOriginalFilename();
        //12sfsd.jpg
        //获取"."的索引位置
        int beginIndex = originalFilename.lastIndexOf(".");
        String suffix="";
        if (beginIndex>0){
            //截取字符串
            suffix = originalFilename.substring(beginIndex);
        }

        String fileName=UUID.randomUUID().toString()+suffix;
        File dest=new File(dir,fileName);
        // 执行保存头像文件
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }

        // 头像路径
        String avatar = "/upload/" + fileName;
        // 从Session中获取uid和username
        Integer uid = getUserId(session);
        String username = getUserName(session);
        User user=new User();
        user.setAvatar(avatar);
        user.setUsername(username);
        user.setUid(uid);
        userService.updateUserAvatar(user);
        return new JsonResult(OK);
    }
}
