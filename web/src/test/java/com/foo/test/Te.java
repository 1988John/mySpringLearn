package com.foo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fooisart
 * @date 20:16 23-08-2019
 */
public class Te {
    public static void main(String[] args) {
        Num n1 = new Num(10);
        Num n2 = new Num(20);
        List<Num> nums = new ArrayList<>();
        nums.add(n2);nums.add(n2);
        long count = nums.stream().map(Num::getA).count();
        Integer integer = nums.stream().map(Num::getA).reduce(Integer::sum).orElse(0);
        System.out.println(count);
        System.out.println(integer);

        System.out.println((int)(1566565815998L - 1566565814997L));
    }
    static class Num {
        int a;

        public Num(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
}
