package com.coek.controller;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 12:38:33
 */

import com.coek.controller.exception.*;
import com.coek.service.exception.*;
import com.coek.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 所有controller的基类
 */
public class BaseController {

    //操作成功的状态码
    public static final Integer OK=200;

    /**从session中获取用户id*/
    public Integer getUserId(HttpSession session){
        return (Integer) session.getAttribute("uid");
    }

    /**从session中获取用户名*/
    public String getUserName(HttpSession session){
        return (String) session.getAttribute("username");
    }


    /**
     * 所有service的异常都在这里获取并处理
     * @param e service抛出的异常
     * @return
     */
   /* @ExceptionHandler(value = {UserServiceException.class, FileUploadException.class})
    public JsonResult<Void> exceptionHandler(Throwable e){

        JsonResult jr=new JsonResult();

        String message=e.getMessage();
        if (e instanceof UserNameOccupyException){
            jr.setState(4000);
            jr.setMessage(message);
        }else if (e instanceof InsertException){
            jr.setState(4001);
            jr.setMessage(message);
        }else if (e instanceof UserNameNotExistException){
            jr.setMessage(message);
            jr.setState(4002);
        }else if (e instanceof UserPwdNotMatchException){
            jr.setState(4003);
            jr.setMessage(message);
        }else if (e instanceof FileEmptyException){
            jr.setState(4004);
            jr.setMessage(message);
        }else if (e instanceof FileSizeException){
            jr.setState(4005);
            jr.setMessage(message);
        }else if (e instanceof FileStateException){
            jr.setState(4006);
            jr.setMessage(message);
        }else if (e instanceof FileUploadIOException){
            jr.setState(4007);
            jr.setMessage(message);
        }else if (e instanceof FileTypeException){
            jr.setState(4008);
            jr.setMessage(message);
        }else if (e instanceof AccessDeniedException){
            jr.setState(4009);
            jr.setMessage(message);
        }else if (e instanceof AddressNotFoundException){
            jr.setState(4010);
            jr.setMessage(message);
        }else if (e instanceof ProductNotFoundException){
            jr.setState(5000);
            jr.setMessage(message);
        }




        return jr;
    }*/


}
