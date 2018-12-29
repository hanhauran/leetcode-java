package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/29 14:46
 */

public class Code766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (! helper(matrix, i, 0)) {
                return false;
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (! helper(matrix, 0, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean helper(int[][] matrix, int x, int y) {
        int val = matrix[x][y];
        x++;
        y++;
        while (x < matrix.length && y < matrix[0].length) {
            if (matrix[x++][y++] != val) {
                return false;
            }
        }
        return true;
    }
}
