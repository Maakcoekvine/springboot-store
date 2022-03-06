package com.coek.configuration;

import com.coek.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-21 17:05:33
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    /**
     * 重写addInterceptors方法，添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String  addPathPatterns="/**";


        //允许访问的资源
        List<String> excludePathPatterns=new ArrayList<>();
        excludePathPatterns.add("/bootstrap3/**");
        excludePathPatterns.add("/css/**");
        excludePathPatterns.add("/images/**");
        excludePathPatterns.add("/js/**");
        excludePathPatterns.add("/web/login.html");
        excludePathPatterns.add("/web/register.html");
        excludePathPatterns.add("/web/product.html");
        excludePathPatterns.add("/web/index.html");
        excludePathPatterns.add("/user/login");
        excludePathPatterns.add("/user/reg");
        excludePathPatterns.add("/districts/**");
        excludePathPatterns.add("/products/**");
        excludePathPatterns.add("/product/getHotList");
        excludePathPatterns.add("/product/getLatestList");

        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns(addPathPatterns).
                excludePathPatterns(excludePathPatterns);
    }
}
