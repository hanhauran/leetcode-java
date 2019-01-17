package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/17 16:07
 */

@Level(Levels.MEDIUM)
@Question("m * n 网格，起始点位于(1,1)，终点位于(m, n)，每次只能向右或向下，求路径总数")
@Method(Methods.DYNAMIC_PROGRAMMING)
public class Code62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Code62 code = new Code62();
        System.out.println(code.uniquePaths(7, 3));
    }
}
