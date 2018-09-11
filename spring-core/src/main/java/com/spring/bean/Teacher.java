package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2018/8/27.
 */
public class Teacher implements FactoryBean {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObject() throws Exception {

        Teacher teacher = new Teacher();
        teacher.setAge(1);
        teacher.setName("abc");
        return teacher;
    }

    public Class<?> getObjectType() {
        return Teacher.class;
    }

    public boolean isSingleton() {
        return Boolean.TRUE;
    }
}
