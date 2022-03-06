package com.coek.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 13:13:09
 */
@Component
@Aspect
public class TimerAspect {
    @Around("execution(* com.coek.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp){

        Object result = null;
        try {
            long begin=System.currentTimeMillis();//毫秒
             result= pjp.proceed();
             long end=System.currentTimeMillis();
            System.out.println("----------共耗时:"+(end-begin)+"ms----------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
