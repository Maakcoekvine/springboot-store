package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 12:52:25
 */

/**
 * 登录时用户名不存在
 */
public class UserNameNotExistException extends UserServiceException{
    public UserNameNotExistException() {
        super();
    }

    public UserNameNotExistException(String message) {
        super(message);
    }

    public UserNameNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameNotExistException(Throwable cause) {
        super(cause);
    }

    protected UserNameNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
