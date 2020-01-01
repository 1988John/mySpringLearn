package com.foo.test.leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author fooisart
 * @date 19:33 02-12-2019
 */
public class TwoCityScheduling1029 {
    public static void main(String[] args) {
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(twoCitySchedCost(costs));
    }
    public static int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int aC = 0;
        int bC = 0;
        int count = 0;
        List<Pair> differs = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            differs.add(new Pair(Math.abs(costs[i][0] - costs[i][1]), i));
        }
        differs.sort(Comparator.comparing(Pair::getDiffer).reversed());
        for (Pair pair : differs) {
            if ( aC == len / 2) {
                count += costs[pair.index][1];
            } else if (bC == len / 2) {
                count += costs[pair.index][0];
            } else if (costs[pair.index][0] < costs[pair.index][1]) {
                aC ++;
                count += costs[pair.index][0];
            } else {
                bC ++;
                count += costs[pair.index][1];
            }
        }
        return count;
    }
    static class Pair {
        int differ;
        int index;

        public int getDiffer() {
            return differ;
        }

        public int getIndex() {
            return index;
        }

        public Pair(int differ, int index) {
            this.differ = differ;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "differ=" + differ +
                    ", index=" + index +
                    '}';
        }
    }
}
