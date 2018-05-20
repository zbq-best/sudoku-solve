package com.ikyxxs.sudoku.utils;

/**
 * 数组工具类
 */
public class ArrayUtil {

    /**
     * 二维数组拷贝
     *
     * @param src 源
     * @return 副本
     */
    public static int[][] clone(int[][] src) {
        if (null == src) {
            return null;
        }

        int[][] dest = new int[9][9];

        for (int i = 0; i < 9; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, 9);
        }

        return dest;
    }

    /**
     * 打印二维数组
     *
     * @param arr 二维数组
     */
    public static void print(int[][] arr) {
        if (null == arr) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
