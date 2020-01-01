package com.foo.test.leetcode.trie;

/**
 * @author fooisart
 * @date 17:32 22-10-2019
 */
public class LongestWordInDictionary720 {
    private TrieNode root = new TrieNode('/');

    public static void main(String[] args) {
        LongestWordInDictionary720 dictionary = new LongestWordInDictionary720();
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        String s = dictionary.longestWord(words);
        System.out.println(s);
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        String result = "";
        for (String word : words) {
            if (isBuild(word) && compareTwoWords(word, result)) {
                result = word;
            }
        }
        return result;
    }
    /**
     * false:first < second
     * @return true:first单词长度对于second单词 或者 他们两长度一样但是first在字典中顺序更靠前
     * @author fooisart
     * @date 21:54 2019/10/22
     */
    public boolean compareTwoWords(String first, String second) {
        if (first.length() < second.length()) {
            return false;
        } else if (first.length() > second.length()){
            return true;
        } else {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) < second.charAt(i)) {
                    return true;
                } else if (first.charAt(i) > second.charAt(i)) {
                    return false;
                }
            }
            return false;
        }
    }

    public void insert(String str) {
        TrieNode p = root;
        for (int i = 0; i < str.length(); ++i) {
            int index = str.charAt(i) - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(str.charAt(i));
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    // 在Trie树中查找一个字符串
    public boolean isBuild(String str) {
        TrieNode p = root;
        for (int i = 0; i < str.length(); ++i) {
            int index = str.charAt(i) - 'a';
            if (p.children[index] == null || !p.children[index].isWord) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        return p.isWord;
    }

    class TrieNode{
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
