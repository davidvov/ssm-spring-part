package com.atguigu.Advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    @Before("execution(* com.atguigu.service.Impl.*.*(..))")
    public void start(){
        System.out.println("方法开始");
    }

    @After("execution(* com.atguigu.service.*.*.*(..))")
    public void end(){
        System.out.println("方法结束");
    }

    @AfterThrowing("execution(* com.atguigu.service.*.*(..))")
    public void error(){
        System.out.println("方法异常");
    }
}
