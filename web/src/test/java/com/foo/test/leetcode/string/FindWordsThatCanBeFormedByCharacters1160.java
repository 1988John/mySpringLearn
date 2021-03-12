package com.foo.test.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangwang
 * @date 2021-03-11 10:31
 */
public class FindWordsThatCanBeFormedByCharacters1160 {
    public static void main(String[] args) {

        String[] words = {"hello","world","leetcode"};
        System.out.println(countCharacters(words, "welldonehoneyr"));
    }
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            Integer times = charsMap.get(c);
            charsMap.put(c, times == null ? 1 : times + 1);
        }
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                Integer times = wordMap.get(c);
                wordMap.put(c, times == null ? 1 : times + 1);
            }
            boolean containWord = true;
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                Integer charsTimes = charsMap.get(entry.getKey());
                if (charsTimes == null || entry.getValue() > charsTimes) {
                    containWord = false;
                    break;
                }
            }
            if (containWord) {
                count += word.length();
            }
        }
        return count;
    }

    public static int countCharacters1(String[] words, String chars) {
        int count = 0;
        for (String word : words) {
            String temp = chars;
            int hitCharNum = 0;
            for (int j = 0; j < word.length(); j++) {
                if (temp.contains(word.charAt(j) + "")) {
                    temp = temp.replaceFirst(word.charAt(j) + "", "");
                    hitCharNum++;
                }
            }
            if (hitCharNum == word.length()) {
                count += hitCharNum;
            }
        }
        return count;
    }
}
