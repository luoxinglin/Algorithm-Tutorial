package com.algorithm.chapter4;

/**
 * @author luo xinglin
 * @date 2019/6/6 - 20:11
 */
public class Test {

    //二维数组的长度：
    //定义一个整型数组:3行4列
    //int a[][] = new int[3][4];
    //获取行数---3行
    //int lenY = a.length;
    //获取列数---4列
    //int lenX = a[0].length;
    //二维矩阵暴力求法，算法复杂度：n*n*n

    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        for (int i = 0; i < a.length; i++) {
            
        }
        int[][] b = {{1,2},{3,4}};
        int[][] c = new int[a.length][b.length];
        test(c, a, b);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.println(c[i][j]);
            }
        }
    }

    public static void test(int[][] resualt, int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    resualt[i][k] = resualt[i][k] + a[i][j] * b[j][k];
                }
            }
        }
    }
}
