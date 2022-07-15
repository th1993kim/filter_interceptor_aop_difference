package com.example.filterinterceptoraopdifference.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CustomAop {

    @Pointcut("within(com.example.filterinterceptoraopdifference.example.controller.*)")
    public void callController(){
    }

    @Before("callController()")
    public void beforeCallController(JoinPoint joinPoint){
        log.info("========AOP Before Advice ==========");
        log.info("target class Name : " +joinPoint.getTarget().getClass().getName());
        log.info("target method Name : " + joinPoint.getSignature().getName());
    }


    @After("callController()")
    public void afterCallController(JoinPoint joinPoint){
        log.info("========AOP After Advice ==========");
    }
}
