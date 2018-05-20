package com.ikyxxs.sudoku.solve;

import com.ikyxxs.sudoku.utils.ArrayUtil;

/**
 * 回溯算法
 */
public class BackTrack {

    /**
     * 输入
     */
    private int[][] input;

    /**
     * 输出
     */
    private int[][] output;

    /**
     * 解决标识
     */
    private boolean isSolved = false;

    /**
     * 解数独并输出
     */
    public int[][] solve(int[][] input) {
        this.input = ArrayUtil.clone(input);
        this.isSolved = false;
        bt(0, 0);
        return output;
    }

    /**
     * 回溯算法数独
     */
    private void bt(int x, int y) {
        if (isSolved) {
            return;
        }
        if (y == 9) {
            isSolved = true;
            output = ArrayUtil.clone(input);
            return;
        }
        if (x == 9) {
            bt(0, y + 1);
            return;
        }
        if (input[x][y] > 0) {
            bt(x + 1, y);
            return;
        }

        for (int n = 1; n <= 9; n++) {
            if (!isConflict(x, y, n)) {
                input[x][y] = n;
                bt(x + 1, y);
                input[x][y] = 0;
            }
        }
    }

    /**
     * 判断数独的(x,y)位置是否允许为数字n
     */
    private boolean isConflict(int x, int y, int n) {
        //行列不重复判断
        for (int i = 0; i < 9; i++) {
            if (input[i][y] == n) {
                return true;
            }
            if (input[x][i] == n) {
                return true;
            }
        }

        int a = x / 3 * 3;
        int b = y / 3 * 3;

        //小九宫不重复判断
        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (input[i][j] == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
