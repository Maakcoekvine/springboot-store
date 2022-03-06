package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 12:53:02
 */

/**
 * 用户登录密码不正确
 */
public class UserPwdNotMatchException extends UserServiceException{

    public UserPwdNotMatchException() {
        super();
    }

    public UserPwdNotMatchException(String message) {
        super(message);
    }

    public UserPwdNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPwdNotMatchException(Throwable cause) {
        super(cause);
    }

    protected UserPwdNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
