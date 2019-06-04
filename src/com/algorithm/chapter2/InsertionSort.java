package com.algorithm.chapter2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author luo xinglin
 * @date 2019/6/4 - 21:16
 */
public class InsertionSort {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int[] nums = {9, 7, 8, 5, 6, 4, 2, 3, 1, 0};
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        scanner.close();
        System.out.println(Arrays.toString(sort(nums)));
    }

    //输入一个无序的数列，用插入排序方法进行排序
    //对于少量元素的排序，是一个好算法
    public static int[] sort(int[] nums) {
        int j, key, temp;
        for (int i = 1; i < nums.length; i++) {
            //用key来表示插入的元素，若直接用nums[i]表示，nums[j+1]操作会更改nums[i]的值
            key = nums[i];
            //j表示从已排好序的数组的最右边开始比较
            j = i - 1;
            while (j >= 0 && key <= nums[j]) {
                //若插入的元素小，则将被比较的元素后移一位
                nums[j + 1] = nums[j];
                j--;
            }
            //此时的nums[j]代表着被插入元素左边相邻的那个元素
            nums[j + 1] = key;
        }
        return nums;
    }
}
