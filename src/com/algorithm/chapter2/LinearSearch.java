package com.algorithm.chapter2;

/**
 * @author luo xinglin
 * @date 2019/6/5 - 16:19
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] nums = {12, 14, 8, 9, 6, 7, 4};
        int key = 4;
        int result = linearSearch(key, nums);
        if (result > 0) {
            System.out.println(result + 1);
        } else {
            System.out.println(0);
        }
    }

    public static int linearSearch(int key, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (key == nums[i]) {
                return i;
            }
        }
        return 0;
    }
}
