package com.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/9/4.
 */
@Aspect
public class Log /*implements MethodBeforeAdvice*/ {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after");
    }

   /* public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("...............before................");
    }*/
}
