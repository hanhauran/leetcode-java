package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/10 14:45
 */

public class Code566 {
    public int[][] matrixReshape(int[][] sums, int r, int c) {
        if (r * c != sums.length * sums[0].length) {
            return sums;
        }

        if (sums.length == r && sums[0].length == c) {
            return sums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = target(sums, i * c + j);
            }
        }
        return result;
    }

    private int target(int[][] sums, int now) {
        int line = now / sums[0].length;
        int row = now - sums[0].length * line;
        return sums[line][row];
    }
}
