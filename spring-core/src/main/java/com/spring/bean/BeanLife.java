package com.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanLife implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor,BeanFactoryPostProcessor,DisposableBean {


    public void setBeanName(String name) {
        System.out.println(1);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(2);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(3);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(4);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(5);
        return bean;
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(6);
    }

    public void destroy() throws Exception {
        System.out.println(7);
    }
}
