package com.spring.aop;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/9/4.
 */
public class AopTest {

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AopTest bean = applicationContext.getBean(AopTest.class);
        bean.test();
    }

}
