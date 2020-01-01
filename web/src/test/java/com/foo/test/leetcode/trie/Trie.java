package com.foo.test.leetcode.trie;

/**
 * @author fooisart
 * @date 22:13 22-10-2019
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));;   // returns true
        System.out.println(trie.search("app"));;   // returns false
        System.out.println(trie.startsWith("app"));; // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));;     // returns true
    }

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(word.charAt(i));
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        return true;
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
