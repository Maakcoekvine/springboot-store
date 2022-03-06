package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 17:12:27
 */
public class UserAddressCountException extends UserServiceException{
    public UserAddressCountException() {
        super();
    }

    public UserAddressCountException(String message) {
        super(message);
    }

    public UserAddressCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAddressCountException(Throwable cause) {
        super(cause);
    }

    protected UserAddressCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
