package com.atguigu.Advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: ssm-spring-part
 * @description:使用普通方式进行事务添加
 * @author: Litian
 * @create: 2025-11-18 19:50
 **/
@Component
@Aspect
public class TxAdvice {
    @Before("com.atguigu.PointCut.MypointCut.pc()")
    public void begin(){
        System.out.println("开启事务");
    }

    @AfterReturning("com.atguigu.PointCut.MypointCut.pc()")
    public void commit(){
        System.out.println("事务提交");
    }

    @AfterThrowing("com.atguigu.PointCut.MypointCut.pc()")
    public void rollback(){
        System.out.println("事务回滚");
    }
}
