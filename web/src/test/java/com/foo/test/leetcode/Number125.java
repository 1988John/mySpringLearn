package com.foo.test.leetcode;

/**
 * @author fooisart
 * @date 10:10 21-08-2019
 */
public class Number125 {
    public static void main(String[] args) {
        String str = "abcba";
        boolean result = isPalindrome3(str);
        System.out.println(result);
    }

    public static boolean isPalindrome3(String s) {
        int len = s.length();
        int i=0,j=len-1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i ++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j --;
            }

            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
                continue;
            }

            if (Character.isDigit(s.charAt(i)) && s.charAt(i) != s.charAt(j)) {
                return false;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        s = s.replaceAll("[^a-z^A-Z^0-9]", "").toUpperCase();
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-1 -i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-z^A-Z^0-9]", "");
        int len = s.length();
        String str1 = s.substring(0, len/2);
        String str2 = new StringBuffer(s.substring(len / 2 + len%2, len)).reverse().toString();
        return str1.equalsIgnoreCase(str2);
    }
}
