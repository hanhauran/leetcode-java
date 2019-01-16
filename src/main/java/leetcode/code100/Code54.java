package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/9 18:20
 */

@Level(Levels.MEDIUM)
@Question("给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。")
public class Code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        int level = 0;
        int min = Math.min(matrix.length, matrix[0].length);
        int maxLevel = min % 2 == 0 ? min / 2 : min / 2 + 1;
        while (level < maxLevel) {
            helper(matrix, level++ , res);
        }
        return res;
    }

    private void helper(int[][] matrix, int level, List<Integer> res) {
        int i, j;
        if (level >= matrix.length - 1 - level) {
            for (i = level; i < matrix[0].length - level; i++) {
                res.add(matrix[level][i]);
            }
            return;
        }

        if (level >= matrix[0].length - 1 - level) {
            for (i = level; i < matrix.length - level; i++) {
                res.add(matrix[i][level]);
            }
            return;
        }

        for (i = level; i < matrix[0].length - 1 - level; i++) {
            res.add(matrix[level][i]);
        }
        j = i;
        for (i = level; i < matrix.length - 1 - level; i++) {
            res.add(matrix[i][j]);
        }
        j = i;
        for (i = matrix[0].length - 1 - level; i > level; i--) {
            res.add(matrix[j][i]);
        }
        j = i;
        for (i = matrix.length - 1 - level; i > level; i--) {
            res.add(matrix[i][j]);
        }
    }

    public static void main(String[] args) {
        Code54 code = new Code54();
        int[][] matrix = {
                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//                {10,11,12}
        };
        int[][] matrix1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(code.spiralOrder(matrix));
//        System.out.println(code.spiralOrder(matrix1));
    }
}
