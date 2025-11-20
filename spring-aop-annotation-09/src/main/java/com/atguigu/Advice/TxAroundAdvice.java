package com.atguigu.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: ssm-spring-part
 * @description:环绕通知
 * @author: Litian
 * @create: 2025-11-18 19:52
 **/

/*
* 环绕通知，需要在通知中，定义目标方法的执行
* @param joinPoint 目标方法（获取目标方法信息，多了一个执行方法）
* @return 目标方法的返回值
* */


@Component
@Aspect
public class TxAroundAdvice {

    @Around("com.atguigu.PointCut.MypointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        //确保目标方法被执行即可
        Object[] args = joinPoint.getArgs();
        Object result;
        try {
            //增强代码
            System.out.println("开启事务");
            result = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }

        return result;
    }
}
