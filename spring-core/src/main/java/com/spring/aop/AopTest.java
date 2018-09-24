package com.spring.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



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
