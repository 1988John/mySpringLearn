package com.foo.test.tree.trie;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author fooisart
 * @date 17:25 22-10-2019
 */
public class MyTrieNode {
//    private boolean isKey; //标记该节点是否代表一个关键字
    private MyTrieNode[] children; //子节点
    private int keyCount; //记录该节点代表关键字的个数
    private char key;

    public MyTrieNode() {
//        this.isKey = false;
        this.keyCount = 0;
        children = new MyTrieNode[26];
    }

    public static void main(String[] args) {
        String[] arr = {"the", "the", "there", "answer", "any", "by", "bye", "their"};
        MyTrieNode root = new MyTrieNode();
        for (String s : arr) {
            root.insertNode(root, s);
        }
        System.out.println(root);

        int the = root.searchNode(root, "there");
        System.out.println(the);

    }

    public MyTrieNode createNode() {
        return new MyTrieNode();
    }

    public void insertNode(MyTrieNode root, String str) {
        MyTrieNode node = root;
        int index;
        for (int i = 0; i < str.length(); i++) {
            char k = str.charAt(i);
            index = k - 'a';
            if (node.getChildren()[index] == null) {
                MyTrieNode tempNode = createNode();
                tempNode.setKey(k);
                node.getChildren()[index] =  tempNode;
            }
            node = node.getChildren()[index];
        }
        node.setKeyCount(node.getKeyCount() + 1);
    }

    public int searchNode(MyTrieNode root, String str) {
        MyTrieNode node = root;
        int index;
        for (int i = 0; i < str.length(); i++) {
            char k = str.charAt(i);
            index = k - 'a';
            if (node.getChildren()[index] != null) {
                node = node.getChildren()[index];
            } else {
                return 0;
            }
        }
        return node.getKeyCount();
    }

    public MyTrieNode[] getChildren() {
        return children;
    }

    public void setChildren(MyTrieNode[] children) {
        this.children = children;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    @Override
    public String toString() {
        MyTrieNode[] list = Arrays.stream(children).filter(Objects::nonNull).toArray(MyTrieNode[]::new);
        return "TrieNode{" +
                "children=" + Arrays.toString(list) +
                ", key=" + key +
                '}';
    }
}

