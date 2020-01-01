package com.foo.test;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 16:19 18-11-2019
 */
public class MyMergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) /2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void merge(int[] arr, int p, int q, int r) {
        int lLen = q - p + 1;
        int rLen = r - q;
        int[] lArr = new int[lLen];
        int[] rArr = new int[rLen];
        int k = p;
        for (int t = 0;t< lLen;t++) {
            lArr[t] = arr[p++];
        }
        for (int t = 0;t < rLen;t++) {
            rArr[t] = arr[++q];
        }
        int i = 0,j = 0;
        while (i < lLen && j < rLen) {
            if (lArr[i] < rArr[j]) {
                arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
            }
        }
        while (i < lLen) {
            arr[k++] = lArr[i++];
        }
        while (j < rLen) {
            arr[k++] = rArr[j++];
        }
    }
}
