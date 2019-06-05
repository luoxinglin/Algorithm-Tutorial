package com.algorithm.chapter2;

import com.algorithm.utils.SortTestHelper;

import java.util.Arrays;

/**
 * @author luo xinglin
 * @date 2019/6/5 - 16:59
 */
public class MergeSort {
    //归并排序思想：https://www.cnblogs.com/chengxiao/p/6194356.html
    //            https://blog.csdn.net/qq_36442947/article/details/81612870
    //时间复杂度：最好：n*log(n)，最坏：n*log(n)
    public static void main(String[] args) {
//        int[] arr = SortTestHelper.getRandomArray(15, 2, 19);
        int[] arr = {2, 1, 2, 6};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }


    //分解数组
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(arr[p1]<=arr[p2])
                tmp[k++]=arr[p1++];
            else
                tmp[k++]=arr[p2++];
        }

        while(p1<=mid) tmp[k++]=arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=arr[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            arr[i]=tmp[i];
    }

}
