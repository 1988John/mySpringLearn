package com.foo.test.leetcode.trie;

/**
 * @author fooisart
 * @date 15:48 25-10-2019
 */
public class WordDictionary {
    TNode root = new TNode('/');

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("abc");
        System.out.println(dictionary.search("ab."));
    }
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TNode(word.charAt(i));
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '.') {

            }
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }
    class TNode {
        boolean isWord = false;
        char value;
        TNode[] children = new TNode[26];

        public TNode(char value) {
            this.value = value;
        }
    }
}
