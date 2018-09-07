package com.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInitSdt {

    public static void main(String[] args) {

//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        Person bean = beanFactory.getBean(Person.class);
//        System.out.println(bean);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        BeanLife bean = applicationContext.getBean(BeanLife.class);
        System.out.println(bean.toString());

    }

}
