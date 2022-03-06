package com.coek.service.exception;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 20:32:40
 */

/**
 * 商品找不到
 */
public class ProductNotFoundException extends UserServiceException{
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
