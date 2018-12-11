package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/11 18:53
 */

public class Code661 {
    public int[][] imageSmoother(int[][] m) {
        int[][] result = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[i][j] = help(m, i, j);
            }
        }
        return result;
    }

    private int help(int[][] m, int x, int y) {
        int sum = 0, num = 0;
        int xl = x - 1, xr = x + 1, yl = y - 1, yr = y + 1;
        int[] xarr = {xl, xl, xl, x, x, x, xr, xr, xr};
        int[] yarr = {yl, y, yr, yl, y, yr, yl, y, yr};
        for (int i = 0; i < xarr.length; i++) {
            if (validate(m, xarr[i], yarr[i])) {
                sum += m[xarr[i]][yarr[i]];
                num++;
            }
        }
        return sum / num;
    }

    private boolean validate(int[][] m, int x, int y) {
        if (x >= 0 && x < m.length && y >= 0 && y < m[0].length) {
            return true;
        }
        return false;
    }
}
