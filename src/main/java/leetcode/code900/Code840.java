package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 20:42
 */

@Level(Levels.EASY)
public class Code840 {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += helper(grid, i, j) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean helper(int[][] grid, int xs, int ys) {
        if (xs + 3 > grid.length || ys + 3 > grid[0].length) {
            return false;
        }

        int[] array = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[xs + i][ys + j] > 9 || grid[xs + i][ys + j] < 1) {
                    return false;
                }
                array[grid[xs + i][ys + j] - 1]++;
            }
        }
        for (int i : array) {
            if (i != 1) {
                return false;
            }
        }

        int sum = grid[xs][ys] + grid[xs][ys + 1] + grid[xs][ys + 2];
        return sum == grid[xs + 1][ys] + grid[xs + 1][ys + 1] + grid[xs + 1][ys + 2]
                && sum == grid[xs + 2][ys] + grid[xs + 2][ys + 1] + grid[xs + 2][ys + 2]
                && sum == grid[xs][ys] + grid[xs + 1][ys] + grid[xs + 2][ys]
                && sum == grid[xs][ys + 1] + grid[xs + 1][ys + 1] + grid[xs + 2][ys + 1]
                && sum == grid[xs][ys + 2] + grid[xs + 1][ys + 2] + grid[xs + 2][ys + 2]
                && sum == grid[xs][ys] + grid[xs + 1][ys + 1] + grid[xs + 2][ys + 2]
                && sum == grid[xs][ys + 2] + grid[xs + 1][ys + 1] + grid[xs + 2][ys];
    }

    public static void main(String[] args) {
        Code840 code = new Code840();
        System.out.println(code.numMagicSquaresInside(new int[][]{
                {10, 3, 5},
                {1, 6, 11},
                {7, 9, 2}
        }));
    }
}
