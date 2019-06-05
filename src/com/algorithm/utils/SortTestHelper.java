package com.algorithm.utils;

/**
 * @author luo xinglin
 * @date 2019/6/5 - 17:07
 */
public class SortTestHelper {
    /**
     *
     * @param n 生成n个元素的随机数组
     * @param rangeL 随机范围[rangeL
     * @param rangeR	rangeR]
     * @return 返回一个随机 int 型数组
     */
    public static int[] getRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL +1)) + rangeL;
        }
        return arr;
    }

}
