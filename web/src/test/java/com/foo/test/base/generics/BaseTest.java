package com.foo.test.base.generics;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * @author Fooisart
 * @date 20:11 18-01-2019
 */
public class BaseTest{
    public static void main(String[] args) {
//        List<Object> list = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        printCollection(list);
//        printCollection(set);
//        Object[] myArray = new String[]{"a", "b", "c"};
//        myArray[1] = 1;
//        System.out.println(myArray[1]);
    }

    static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }

    }

    private static List<Long> getList(){
        return null;
    }


    public <B> void test1(Class<B> b,Function<B, Object> builder){
    }

//    public void assgin(){
//        BaseTest b = new BaseTest();
//        b.test1(BaseTest.class,BaseTest :: getList);
//    }



}
