package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:21:03
 */

/**
 * 添加、修改数据异常
 */
public class InsertException extends UserServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
