package com.foo.test.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fooisart
 * @date 2019-12-06 16:47
 */
public class BinaryWatch401 {
    public static void main(String[] args) {
        List<String> list = readBinaryWatch(5);
        System.out.println(list);
    }
    public  static List<String> readBinaryWatch(int num) {
        if (num <= 0) {
            List<String> result = new ArrayList<>();
            result.add("0:00");
            return result;
        }
        int[] minutes = {1,2,4,8,16,32,60,120,240,480};
        List<Integer> minutesList = new ArrayList<>();
        List<Integer> selectedMinutes = new ArrayList<>();
        calculateMinutes(minutes, 0, 0, num, minutesList, selectedMinutes);
        minutesList.sort(Comparator.naturalOrder());
        return minutesList.stream()
                .map(BinaryWatch401::minutesToStr)
                .collect(Collectors.toList());
    }
    private static void calculateMinutes(int[] minutes, int minutesCount, int index, int num, List<Integer> minutesList,
                                         List<Integer> selectedMinutes) {
        if (num <= 0) return;
        int selectedMinute = selectedMinutes.stream().mapToInt(x -> x).sum();
        if (selectedMinute >= 60) {
            return;
        }

        for (int i = index; i <= minutes.length - num; i++) {
            if (num == 1) {
                if (minutesCount + minutes[i] < 12 * 60) {
                    if ((i <= 5)) {
                        if (minutes[i] + selectedMinute < 60) {
                            minutesList.add(minutesCount + minutes[i]);
                        }
                    } else {
                        minutesList.add(minutesCount + minutes[i]);
                    }
                }
                System.out.println(selectedMinutes);
            } else {
                if ((i <= 5)) {
                    selectedMinutes.add(minutes[i]);
                }
                calculateMinutes(minutes, minutesCount + minutes[i], i+1, num-1, minutesList, selectedMinutes);
                if ((i <= 5)) {
                    selectedMinutes.remove(selectedMinutes.size()-1);
                }
            }
        }
    }
    private static String minutesToStr(int minute) {
        int h = minute / 60;
        int m = minute % 60;
        return m >= 10 ? h + ":" + m : h + ":0" + m;
    }
}
