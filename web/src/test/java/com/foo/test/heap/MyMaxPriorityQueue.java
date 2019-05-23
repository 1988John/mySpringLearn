package com.foo.test.heap;

/**
 * @author fooisart
 * @date 16:36 22-05-2019
 */
public class MyMaxPriorityQueue {
    private int[] elements = new int[36];
    int lastIndex = -1;

    public int[] elements() {
        return elements;
    }

    public Integer findMax() {
        if (lastIndex <0) {
            return null;
        }
        return elements[0];
    }

    public Integer extractMax() {
        if (lastIndex <0) {
            return null;
        }
        int max = elements[0];
        siftDown();
        return max;
    }

    public void add(int e) {
        elements[++lastIndex] = e;
        siftUp();
    }

    private int parent(int index) {
        return (index -1)/2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void siftUp() {
        int tmpIndex = lastIndex;
        while (tmpIndex > 0 && elements[tmpIndex] > elements[parent(tmpIndex)]) {
            int temp = elements[parent(tmpIndex)];
            elements[parent(tmpIndex)] = elements[tmpIndex];
            elements[tmpIndex] = temp;
            tmpIndex = parent(tmpIndex);
        }
    }

    private void siftDown() {
        elements[0] = elements[lastIndex];
        elements[lastIndex] = 0;
        lastIndex --;

        int maxIndex = 0;
        while (maxIndex < lastIndex && elements[maxIndex] < Math.max(elements[leftChild(maxIndex)], elements[rightChild(maxIndex)])) {
            int tmpIndex = Math.max(leftChild(maxIndex), rightChild(maxIndex));
            int tmp = elements[maxIndex];
            elements[maxIndex] = elements[tmpIndex];
            elements[tmpIndex] = tmp;
            maxIndex = tmpIndex;
        }

    }

}
