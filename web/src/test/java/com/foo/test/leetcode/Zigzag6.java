package com.foo.test.leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fooisart
 * @date 17:52 27-08-2019
 */
public class Zigzag6 {
    public static void main(String[] args) {
        String s = "PA";
        String convert = convert(s, 1);
        System.out.println(convert);

    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int down = 1; //向下 +1，向上-1

        List<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }
        int m = -1;
        for (int i = 0; i < s.length(); i++) {
            m += down;
            builders.get(m).append(s.charAt(i));
            if (m == 0) {
                down = 1;
            }
            if (m == numRows-1) {
                down = -1;
            }
        }
        return builders.stream().collect(Collectors.joining());
    }

}
