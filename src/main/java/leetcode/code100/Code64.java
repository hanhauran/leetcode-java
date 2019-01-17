package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/17 16:58
 */

@Level(Levels.MEDIUM)
@Link(Code63.class)
@Question("给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。")
@Method(Methods.DYNAMIC_PROGRAMMING)
public class Code64 {
    public int minPathSum(int[][] grid) {
        int[][] marker = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    marker[i][j] = grid[i][j];
                } else if (i == 0) {
                    marker[i][j] = marker[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    marker[i][j] = marker[i - 1][j] + grid[i][j];
                } else {
                    marker[i][j] = Math.min(marker[i - 1][j], marker[i][j - 1]) + grid[i][j];
                }
            }
        }
        return marker[grid.length - 1][grid[0].length - 1];
    }
}
