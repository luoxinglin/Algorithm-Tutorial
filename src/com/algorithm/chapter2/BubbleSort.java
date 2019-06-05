package com.algorithm.chapter2;

import com.algorithm.utils.SortTestHelper;

import java.util.Arrays;

/**
 * @author luo xinglin
 * @date 2019/6/5 - 20:08
 */
public class BubbleSort {

    //冒泡排序：反复交换相邻的未按次序排列的元素
    public static void main(String[] args) {
        int[] arr = SortTestHelper.getRandomArray(15, 2, 20);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
