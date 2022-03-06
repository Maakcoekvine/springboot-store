package com.coek.ex;

import com.coek.controller.exception.*;
import com.coek.service.exception.*;
import com.coek.utils.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:MaakcoekVine
 * @Date:2022-02-12 00:03:02
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler({UserServiceException.class, FileUploadException.class})
    @ResponseBody
    public JsonResult globalExceptionHandler(Throwable e){

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
    }
}
