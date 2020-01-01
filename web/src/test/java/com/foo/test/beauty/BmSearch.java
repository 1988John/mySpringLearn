package com.foo.test.beauty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fooisart
 * @date 10:45 29-11-2019
 */
public class BmSearch {
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String source = "abcacabdc";
        String pattern = "abd";
        buildBacCharIndexMap(pattern);
        compareStr(source, pattern);
    }
    /**
     * 判断是否存在
     *
     * @author fooisart
     * @date 11:54 2019/11/29
     */
    private static void compareStr(String source, String pattern) {
        int tempTail = pattern.length()-1;
        while (tempTail < source.length()) {
            System.out.println("tempTail:" + tempTail);
            int compareCount = 0;
            for (int i = pattern.length()-1, j=0; i >= 0; i--, j++) {
                char tempC = source.charAt(tempTail - j);
                System.out.println("比对：" + tempC);
                if (tempC != pattern.charAt(i)) {
                    tempTail += getMoveIndex(pattern, tempC);
                    break;
                }
                compareCount ++;
            }
            if (compareCount == pattern.length()) {
                System.out.println("success");
                return;
            }
        }
    }

    /**
     * 获取移动位数
     *
     * @author fooisart
     * @date 11:54 2019/11/29
     */
    private static int getMoveIndex(String pattern, char tempC) {
        return badChar(tempC, pattern);
    }


    public static int badChar(char c, String pattern) {
        Integer index = map.get(c);
        int i = map.get(c) == null ? pattern.length() : index;
        System.out.println("向后移动：" + i);
        return i;
    }
    public static void buildBacCharIndexMap(String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            int temp = i + 1;
            map.put(pattern.charAt(i), pattern.length() - temp);
        }
    }
}
