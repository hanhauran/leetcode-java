package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 10:00
 */

public class Code463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += helper(grid, i, j);
                }
            }
        }

        return count;
    }

    private int helper(int[][] grid, int i, int j) {
        int count = 0;

        // top
        if (i - 1 >= 0) {
            if (grid[i - 1][j] == 0) {
                count++;
            }
        } else {
            count++;
        }

        // left
        if (j - 1 >= 0) {
            if (grid[i][j - 1] == 0) {
                count++;
            }
        } else {
            count++;
        }

        // bottom
        if (i + 1 < grid.length) {
            if (grid[i + 1][j] == 0) {
                count++;
            }
        } else {
            count++;
        }

        // right
        if (j + 1 < grid[0].length) {
            if (grid[i][j + 1] == 0) {
                count++;
            }
        } else {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Code463 code = new Code463();
        System.out.println(code.islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }
}
