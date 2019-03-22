package com.foo.test.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Fooisart
 * @date 16:00 18-03-2019
 */
public class AtomicReferenceFieldUpdaterTest {
    public static void main(String[] args) throws Exception
    {
        AtomicReferenceFieldUpdater<Dog,String> updater=AtomicReferenceFieldUpdater.newUpdater(Dog.class,String.class,"name");
        Dog dog1=new Dog();
        updater.compareAndSet(dog1,dog1.name,"test") ;
        System.out.println(dog1.name);

    }
}

class Dog
{
    volatile  String name="dog1";

}
