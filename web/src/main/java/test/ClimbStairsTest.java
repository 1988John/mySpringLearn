package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 / 2
 *
 * @author jiangwang
 * @date 2021-03-04 12:09
 */
public class ClimbStairsTest {
    private static final Map<Integer, Integer> stairsMap = new HashMap<>();
    static {
        //初始化
        stairsMap.put(1,1);
        stairsMap.put(2,2);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbWays(n));

        System.out.println(dynamicClimbWays(n));

        System.out.println(dynamicClimbWays1(n));
    }
    /**
     * 1--> 1
     * 2 --> 2
     * 3 -->
     *
     * @date 2021/3/4 12:11
     */
    public static int climbWays(int n) {
        Integer cacheWays = stairsMap.get(n);
        if (cacheWays != null) {
            return cacheWays;
        }
        int ways = climbWays(n - 1) + climbWays(n - 2);
        stairsMap.putIfAbsent(n, ways);
        return ways;
    }
    /**
     * f(n) = f(n-1) + f(n-2)
     *
     * @date 2021/3/4 12:23
     */
    public static int dynamicClimbWays(int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 0; i < n - 2; i++) {
            ways[i + 2] = ways[i] + ways[i+1];
        }
        return ways[n-1];
    }

    public static int dynamicClimbWays1(int n) {
        int p1 = 1;
        int p2 = 2;
        int result = 0;

        for (int i = 1; i <= n - 2; i++) {
            result = p1 + p2;
            p1 = p2;
            p2 = result;

        }
        return result;
    }


}
