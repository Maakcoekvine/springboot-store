package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:13:07
 */

/**
 * 注册时用户名字已存在
 */
public class UserNameOccupyException extends UserServiceException{
    public UserNameOccupyException() {
        super();
    }

    public UserNameOccupyException(String message) {
        super(message);
    }

    public UserNameOccupyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameOccupyException(Throwable cause) {
        super(cause);
    }

    protected UserNameOccupyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
