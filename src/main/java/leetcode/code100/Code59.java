package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/16 21:41
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。",
        input = "3",
        output = "[ [1,2,3], [8,9,4], [7,6,5]"
)
public class Code59 {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] res = new int[n][n];
        int levels = (n - 1) / 2;
        int start = 1;
        int level = 0;
        while (level <= levels) {
            start = insert(res, start, level++);
        }

        return res;
    }

    private int insert(int[][] res, int start, int level) {
        for (int i = level; i < res[0].length - level; i++) {
            res[level][i] = start++;
        }
        for (int i = level + 1; i < res.length - level; i++) {
            res[i][res.length - level - 1] = start++;
        }
        for (int i = res[0].length - level - 2; i >= level; i--) {
            res[res.length - level - 1][i] = start++;
        }
        for (int i = res.length - level - 2; i > level; i--) {
            res[i][level] = start++;
        }
        return start;
    }

    public static void main(String[] args) {
        Code59 code = new Code59();
        int[][] res = code.generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
