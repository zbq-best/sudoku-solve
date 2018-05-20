package com.ikyxxs.sudoku;

import com.ikyxxs.sudoku.solve.BackTrack;
import com.ikyxxs.sudoku.utils.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 算法单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolveTest {

    //待解数独
    private final static int[][] input = new int[][]{
            {3, 4, 8, 0, 0, 0, 0, 0, 0},
            {0, 6, 1, 0, 0, 4, 0, 9, 0},
            {0, 0, 0, 0, 6, 1, 0, 0, 0},
            {0, 0, 7, 5, 0, 0, 0, 6, 0},
            {1, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 3, 1, 0, 8, 0, 0, 4},
            {9, 1, 6, 0, 7, 0, 0, 4, 0},
            {0, 0, 0, 4, 0, 6, 1, 0, 3},
            {0, 0, 2, 0, 0, 5, 0, 0, 6}
    };

    //完整数独
    private final static int[][] answer = new int[][]{
            {3, 4, 8, 9, 5, 2, 6, 1, 7},
            {7, 6, 1, 3, 8, 4, 5, 9, 2},
            {5, 2, 9, 7, 6, 1, 4, 3, 8},
            {2, 8, 7, 5, 4, 9, 3, 6, 1},
            {1, 5, 4, 6, 3, 7, 2, 8, 9},
            {6, 9, 3, 1, 2, 8, 7, 5, 4},
            {9, 1, 6, 2, 7, 3, 8, 4, 5},
            {8, 7, 5, 4, 9, 6, 1, 2, 3},
            {4, 3, 2, 8, 1, 5, 9, 7, 6}
    };

    /**
     * 回溯算法单元测试
     */
    @Test
    public void btTest() {
        BackTrack bt = new BackTrack();
        int[][] output = bt.solve(input);

        ArrayUtil.print(output);
        Assert.assertArrayEquals(answer, output);
    }
}
