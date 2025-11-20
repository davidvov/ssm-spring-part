package com.atguigu.PointCut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: ssm-spring-part
 * @description: 存储切点的类
 * @author: Litian
 * @create: 2025-11-18 19:21
 **/

@Component
public class MypointCut {
    @Pointcut("execution(* com.atguigu.service.Impl.*.*(..))")
    public void pc(){}

}
