package com.algorithm.chapter6;

import java.util.Arrays;

/**
 * @author luo xinglin
 * @date 2019/6/7 - 19:58
 */
public class HeapSort {
    /**
     1. 时间复杂度: O(nlgn)        ==归并排序
     2. 堆排序具有空间原址性：任何时候都只需要常数个额外的元素空间存储临时数据       ==插入排序
     3. 堆是一个数组，可以被近似的看成一个完全二叉树
     4. 二叉堆：最大堆，最小堆
        4.1. 最大堆：每个节点的值至多与父节点的值一样大，堆中最大元素为根元素
        4.2. 最小堆：每个节点的值至少与父节点的值一样大，堆中最小元素为根元素
     5. 堆排序时，使用最大堆，最小堆通常用来构造优先队列
     6. Max-Heapify过程：时间复杂度O(lgn)，维护最大堆性质的关键
        Build-Max-Heap：具有线性时间复杂度，功能是从无序的输入数组中构造一个最大堆
        HeapSort：堆排序，时间复杂度O(nlgn)，对一个数组进行原址排序
        Max-Heap-Insert，Heap-Extract-Max，Heap-Increase-Key，Heap-Maximum，时间复杂度：O(lgn),利用堆实现一个优先队列

     *
     */

    public static void main(String[] args) {
        int[] arr = {19,7,5,6,13,10,18,15,1,2,4};
        Heap_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //找出每个3个元素的二元树中的最大值，作为根元素
    public static void Max_Heapify(int[] arr, int i, int heapSize) {
        int l = i<<1;
        int r = l + 1;
        int largest;
        int temp;
        if (l <= heapSize && arr[l-1] >= arr[i-1]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && arr[r-1] >= arr[largest-1]) {
            largest = r;
        }
        if (largest != i) {
            temp = arr[i-1];
            arr[i-1] = arr[largest-1];
            arr[largest-1] = temp;
            Max_Heapify(arr, largest, heapSize);
        }
    }

    public static void Build_Max_Heap(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2; i >= 1; i--) {
            Max_Heapify(arr, i, heapSize);
        }
    }

    public static void Heap_Sort(int[] arr) {
        int temp;
        int heapSize = arr.length;
        Build_Max_Heap(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length-1; i >= 1; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            Max_Heapify(arr, 1, heapSize);
        }
    }

}
