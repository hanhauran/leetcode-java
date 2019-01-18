package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/18 10:03
 */

@Level(Levels.HARD)
@Question("给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。")
@Method(Methods.DYNAMIC_PROGRAMMING)
public class Code72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }

        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }

        return dp(word1.toCharArray(), word2.toCharArray());
    }

    /**
     * 定义表达式 D(i,j)，表示 cf 从 0 至 i 形成的字串和 cs 从 0 至 j形成字串的编辑距离
     * 则 D(i,0) = i, D(0,j) = j;
     * 如果 cf[i] == cs[j], 那么 D(i,j) = D(i - 1, j - 1)
     * 否则，D(i,j) = MAX(D(i-1,j)+1, D(i,j-1)+1, D(i-1,j-1)+1)
     * @param cf
     * @param cs
     * @return
     */
    private int dp(char[] cf, char[] cs) {
        int[][] marker = new int[cf.length + 1][cs.length + 1];
        for (int i = 0; i < marker.length; i++) {
            marker[i][0] = i;
        }
        for (int i = 0; i < marker[0].length; i++) {
            marker[0][i] = i;
        }

        for (int i = 0; i < cf.length; i++) {
            for (int j = 0; j < cs.length; j++) {
                if (cf[i] == cs[j]) {
                    marker[i + 1][j + 1] = marker[i][j];
                } else {
                    marker[i + 1][j + 1] = Math.min(marker[i][j], Math.min(marker[i][j + 1], marker[i + 1][j])) + 1;
                }
            }
        }
        return marker[cf.length][cs.length];
    }

    public static void main(String[] args) {
        Code72 code = new Code72();
        System.out.println(code.minDistance("intention", "execution"));
    }
}
