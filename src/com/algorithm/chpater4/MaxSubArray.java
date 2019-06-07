package com.algorithm.chpater4;

import java.util.Arrays;

/**
 * @author luo xinglin
 * @date 2019/6/6 - 17:00
 */
public class MaxSubArray {

    //分治法的基本思想是将问题划分为一些子问题，子问题的形式与原问题一样，只是规模更小，递归地求解出子问题，
    //如果子问题的规模足够小，则停止递归，直接求解，最后将子问题的解组合成原问题的解。
    //对于最大子数组，我们要寻求子数组A[low...high]的最大子数组。令mid为该子数组的中央位置，
    //我们考虑求解两个子数组A[low...mid]和A[mid+1...high]。A[low...high]的任何连续子数组A[i...j]所处的位置必然是以下三种情况之一：
    //
    //  1. 完全位于子数组A[low...mid]中,因此low≤i≤j≤mid.
    //  2. 完全位于子数组A[mid+1...high]中,因此mid<i≤j≤high.
    //  3. 跨越了中点，因此low≤i≤mid<j≤high.
    //因此，最大子数组必定为上述3种情况中的最大者。对于情形1和情形2，可以递归地求解，剩下的就是寻找跨越中点的最大子数组。
    //任何跨越中点的子数组都是由两个子数组A[i...mid]和A[mid+1...j]组成，其中low≤i≤mid且mid<j≤high.
    //因此，我们只需要找出形如A[i...mid]和A[mid+1...j]的最大子数组，然后将其合并即可，这可以在线性时间内完成。
    //过程FIND-MAX-CROSSING-SUBARRAY接收数组A和下标low、mid和high作为输入，返回一个下标元组划定跨越中点的最大子数组的边界，
    //并返回最大子数组中值的和。

    //时间复杂度：n * lgn

    public static void main(String[] args) {
        //int[] arr = {13, -3, -25, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] arr = {13, -3, -25};
        int[] result = findMaximumSubArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));

    }

    public static int[] findMaximumSubArray(int[] arr, int low, int high) {
        int mid;
        if (low == high) {
            return new int[]{low, high, arr[low]};
        } else {
            mid = (low + high) / 2;
            int[] resultLeft = findMaximumSubArray(arr, low, mid);
            int[] resultRight = findMaximumSubArray(arr, mid + 1, high);
            int[] resultMid = foundMaxCrossingSubArray(arr, low, mid, high);
            if (resultLeft[2] >= resultLeft[2] + resultRight[2] && resultLeft[2] + resultRight[2] >= resultMid[2]) {
                return  resultLeft;
            } else if (resultRight[2] >= resultLeft[2] + resultRight[2] && resultLeft[2] + resultRight[2] >= resultMid[2]) {
                return resultRight;
            } else {
                return resultMid;
            }
        }
    }

    public static int[] foundMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
        int leftSum = -100000;
        int maxLeft = 0;
        int sum1 = 0;
        for (int i = mid; i >= low; i--) {
            sum1 = sum1 + arr[i];
            if (sum1 > leftSum) {
                leftSum = sum1;
                maxLeft = i;
            }
        }
        int rightSum = -100000;
        int maxRight = 0;
        int sum2 = 0;
        for (int j = mid+1; j <= high; j++) {
            sum2 = sum2 + arr[j];
            if (sum2 > rightSum) {
                rightSum = sum2;
                maxRight = j;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
