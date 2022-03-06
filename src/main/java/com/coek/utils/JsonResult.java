package com.coek.utils;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 11:48:21
 */

import java.io.Serializable;

/**
 * 响应数据结果
 * @param <E>
 *
 */
public class JsonResult<E> implements Serializable {

    public Integer state;

    public String message;

    //E为任意类型的数据
    public E data;

    public JsonResult(){

    }
    public JsonResult(Integer state){
        this.state=state;
    }

    /**
     * 出现异常
     * @param state
     *
     */
    public JsonResult(Integer state,Throwable e){
        this.state=state;
        this.message=e.getMessage();
    }

    public JsonResult(Integer state,E data){
        this.state=state;
        this.data =data;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "message='" + message + '\'' +
                '}';
    }
}
