package com.atguigu.Advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: ssm-spring-part
 * @description: 定义四个增强方法，获取目标方法的信息 返回值 异常对象
 * @author: Litian
 * @create: 2025-11-18 18:48
 **/
@Aspect
@Component
public class MyAdvice {
    /*
    * 切点表达式的提取和复用
    *
    * */

    @Before("com.atguigu.PointCut.MypointCut.pc()")
    public void start(){
        System.out.println("方法开始");
    }

    @After("com.atguigu.PointCut.MypointCut.pc()")
    public void end(){
        System.out.println("方法结束");
    }

    @AfterThrowing("com.atguigu.PointCut.MypointCut.pc()")
    public void error(){
        System.out.println("方法异常");
    }
}
