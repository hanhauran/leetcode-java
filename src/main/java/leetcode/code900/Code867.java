package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/3 9:48
 */

@Level(Levels.EASY)
public class Code867 {
    public int[][] transpose(int[][] a) {
        int[][] result = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }
}
