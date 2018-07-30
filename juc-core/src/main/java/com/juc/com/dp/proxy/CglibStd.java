package com.juc.com.dp.proxy;

import java.lang.reflect.InvocationTargetException;

public class CglibStd {

    public static void main(final String[] args) throws InvocationTargetException {

//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Person.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("before.............");
//                Object invoke = methodProxy.invokeSuper(o, objects);
//                System.out.println("after..............");
//                return invoke;
//            }
//        });
//        Person person = (Person)enhancer.create();
//        System.out.println(person.getName());
//        System.out.println(person.getAge());

//        Person person = new Person("jyang",11);
//        FastClass fastClass = FastClass.create(Person.class);
//        FastMethod getName = fastClass.getMethod("setName", new Class[]{String.class});
//        getName.invoke(person,new Object[]{"jyang22"});
//        System.out.println(person.getName());
        System.out.println(char[].class);
    }

}
