package com.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanInitSdt {

    public static void main(String[] args) {

//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        Person bean = (Person) beanFactory.getBean("person");
//        Student student = (Student) beanFactory.getBean("student");
//        Teacher teacher = beanFactory.getBean(Teacher.class);
//        Bar bar = beanFactory.getBean(Bar.class);
//        System.out.println(bar);
//        System.out.println(bean+""+student+""+teacher);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Student person = applicationContext.getBean(Student.class);
        System.out.println(person);

//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        SimpleBeanDefinitionRegistry defaultListableBeanFactory = new SimpleBeanDefinitionRegistry();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
//        reader.loadBeanDefinitions(resource);
//        BeanDefinition person = defaultListableBeanFactory.getBeanDefinition("person");
//        String factoryBeanName = person.getFactoryBeanName();
//        System.out.println(factoryBeanName);
//        System.out.println(person.toString());
    }

}
