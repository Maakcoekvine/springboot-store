package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-25 17:45:56
 */

/**
 * 如果该数据中记录的uid与当前登录的用户的uid不一致
 */
public class AccessDeniedException extends UserServiceException{
    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
