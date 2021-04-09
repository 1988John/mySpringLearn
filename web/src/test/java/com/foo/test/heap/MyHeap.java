package com.foo.test.heap;

import java.util.Arrays;

/**
 * @author jiangwang
 * @date 2021-03-31 17:53
 */
public class MyHeap {
    public static void main(String[] args) {
        int[] arr = {1,4,9,2,5,8,6};
        System.out.println("原数组：" + Arrays.toString(arr));
        buildMaxHeap(arr);
        System.out.println("堆化：" + Arrays.toString(arr));

    }
    private static int left(int i) {
        return i * 2;
    }

    private static int right(int i) {
        return i * 2 + 1;
    }

    private static int parent(int i) {
        return i / 2;
    }

    private static void exchange(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void maxHeap(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < arr.length && arr[l] > arr[i]) {
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(arr, largest, i);
            maxHeap(arr, largest);
        }

    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeap(arr, i);
        }
    }
}
