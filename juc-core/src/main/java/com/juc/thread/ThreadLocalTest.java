package com.juc.thread;

import com.juc.com.dp.proxy.Person;

public class ThreadLocalTest {

    private static final ThreadLocal<Person> personThreadLocal = new ThreadLocal<Person>();

    public static void main(String[] args) {

        final Person person = new Person("jy",10);
        personThreadLocal.set(person);

        Person person1 = personThreadLocal.get();
        System.out.println(Thread.currentThread().getName()+person1);
        person1.setAge(20);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                personThreadLocal.set(person);
                Person person1 = personThreadLocal.get();
                System.out.println(Thread.currentThread().getName()+person1);
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                Person person1 = personThreadLocal.get();
                System.out.println(Thread.currentThread().getName()+person1);
            }
        },"t2");
        t2.start();



    }

}
