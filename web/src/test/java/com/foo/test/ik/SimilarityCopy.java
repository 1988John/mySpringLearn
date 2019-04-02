package com.foo.test.ik;
 
import java.util.Arrays;
import java.util.List;

/**
 * @author Fooisart
 * @date 17:37 26-03-2019
 */
public class SimilarityCopy {
    /**
     * 求余弦相似度
     * @author Fooisart
     * @date 21:01 2019/3/26
     */
    public static double figureCosine(List<Double> list1, List<Double> list2) {
        return pointMulti(list1,list2) / sqrtMulti(list1,list2);
    }
 
    private static double sqrtMulti(List<Double> list1, List<Double> list2) {
        double result = squares(list1,list2);
        result = Math.sqrt(result);
        return result;
    }
 
    // 求平方和
    private static double squares(List<Double> list1, List<Double> list2) {
        double result1 = 0;
        double result2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            result1 += (list1.get(i) * list1.get(i));
            result2 += (list2.get(i) * list2.get(i));
        }
        return result1 * result2;
    }
 
    // 点乘法
    private static double pointMulti(List<Double> list1, List<Double> list2) {
        double result = 0;
        for (int i = 0; i < list1.size(); i++) {
            result += (list1.get(i) * list2.get(i));
        }
        return result;
    }
 
    public static void main(String[] args) {
        String s1 = "我是一个帅哥";
        String s2 = "帅哥是我";
        List<Double> list1 = Arrays.asList(1.0,1.0,1.0,1.0,1.0,1.0);
        List<Double> list2 = Arrays.asList(1.0,1.0,0.0,0.0,1.0,1.0);
        System.out.println(list1);
        System.out.println(figureCosine(list1,list2));
    }
 
}