package com.coek.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 17:01:52
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("uid");
        if (null==obj){
            //没登录
            response.sendRedirect(request.getContextPath()+"/web/login.html");
            return false;
        }
        return true;

    }
}
