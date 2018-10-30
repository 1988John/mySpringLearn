package com.foo.test;

/**
 * 句子处理工具反转
 *
 * @author jiangwang
 * @date 15:04 2018/10/30
 */
public class SentenceUtils {

    private static final String BLANK = " ";
    private static final String PUNCTUATION = ",.?";

    /**
     * 句子反转
     *
     * @param sentence 待反转的句子
     * @return 反转结果
     * @author jiangwang
     * @date 15:10 2018/10/30
     */
    public static String reversalSentence(String sentence) {

        //获取句子尾部标点符号
        String tail = sentence.substring(sentence.length() - 1);
        if (PUNCTUATION.contains(tail)) {
            //句子尾部为标点符号，需将尾部符号去掉，反转完成之后添加符号。
            sentence = sentence.substring(0, sentence.length() - 1);
        } else {
            //句子末尾没有标点符号，遂将尾部置位空
            tail = "";
        }

        // 按空格划分句子
        String[] words = sentence.split(BLANK);
        StringBuilder result = new StringBuilder();

        // 逆序拼接单词
        for (int j = words.length - 1; j >= 0; --j) {
            result.append(words[j]);
            //最后一个单词后不需加空格,加句子原来的标点符号
            if (j != 0) {
                result.append(BLANK);
            } else {
                result.append(tail);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "what are you doing.";
        String result = SentenceUtils.reversalSentence(sentence);
        System.out.println("[reverse result]: " + result);
    }
}