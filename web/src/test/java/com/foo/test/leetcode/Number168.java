package com.foo.test.leetcode;

/**
 * @author jiangwang
 * @date 2020-08-28 12:09
 */
public class Number168 {
    public static void main(String[] args) {

        System.out.println(convertToTitle(704));
    }
    public static String convertToTitle(int n) { // A ~ Z == 65 ~ 90
        StringBuilder sb = new StringBuilder();
        while(n > 26){
            int i= n%26;
            if(i==0){
                sb.append("Z");
                n/=26;
                --n;
            }
            else{
                sb.append((char)(i+'A'-1));
                n/=26;
            }
        }
        sb.append((char)(n+'A'-1));
        return sb.reverse().toString();
    }
}
