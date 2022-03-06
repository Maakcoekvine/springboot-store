package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:10:33
 */

/**
 * 用户业务异常基类
 */
public class UserServiceException extends RuntimeException{
    public UserServiceException() {
        super();
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceException(Throwable cause) {
        super(cause);
    }

    protected UserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
