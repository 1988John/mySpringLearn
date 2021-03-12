package com.foo.test.base;

/**
 * @author jiangwang
 * @date 2021-03-08 21:51
 */
public class Test {
    public static void main(String[] args) {
        int[][] arr = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
        print(arr);
    }
    public static void print(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (2*j <= len) {
                    if(2 * j >= i) {
                        System.out.print(arr[i][j] + " ");
                    }
                } else {
                    if(2*j <= 2*len - i) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

}
