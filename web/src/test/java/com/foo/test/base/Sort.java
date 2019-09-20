package com.foo.test.base;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 23:04 30-08-2019
 */
public class Sort {
//    public static void main(String[] args) {
//        int[] arr = {4,6,1,9,2,5,0};
//        int[] bubbleResultInts = bubbleSort(arr);
//        System.out.println(Arrays.toString(bubbleResultInts));
//
//        int[] arr1 = {4,6,1,9,2,5,0};
//        int[] insertResultInts = insertSort(arr1);
//        System.out.println(Arrays.toString(insertResultInts));
//
//        int[] arr2 = {4,6,1,9,2,5,0};
//        int[] insertResultInts1 = standardInsertSort(arr2);
//        System.out.println(Arrays.toString(insertResultInts1));
//    }
    public static int[] standardInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i-1;
            for (; j >=0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }
    public static int[] insertSort(int[] arr) {
        for (int pos = 1; pos < arr.length; pos++) {
            for (int i = 0;i<pos;i++) {
                if (arr[i] > arr[pos]) {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minValue = arr[i];
            int minIndex = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {

                }
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        int[] arr1 = {4,6,1,9,2,5,0};
//        int[] arr = {7,4,6};
//        mergeSort(arr1);
//        System.out.println(Arrays.toString(arr1));
//    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid =  (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left,r = mid + 1;
        int t = l;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                l ++;
            } else {
                temp[t] = arr[r];
                r ++;
            }
            t ++;
        }
        while (l <= mid) {
            temp[t] = arr[l];
            l ++;
            t ++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            r ++;
            t ++;
        }
        while (left <= right) {
            arr[left] = temp[left++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 6, 1, 9, 2, 5, 0,11,11};
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition-1);
        quickSort(arr, partition + 1, right);

    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void countingSort(int[] a) {

    }






}
