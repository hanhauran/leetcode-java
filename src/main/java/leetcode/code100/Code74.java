package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/18 19:48
 */

@Level(Levels.MEDIUM)
@Question("编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：" +
        "1.每行中的整数从左到右按升序排列。" +
        "2.每行的第一个整数大于前一行的最后一个整数。")
public class Code74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i;
        for (i = 0; i < matrix.length; i++) {
            if (target < matrix[i][0]) {
                break;
            }
        }

        if (i == 0) {
            return false;
        }
        System.out.println(Arrays.binarySearch(matrix[i - 1], target));
        return Arrays.binarySearch(matrix[i - 1], target) >= 0;
    }

    public static void main(String[] args) {
        Code74 code = new Code74();
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(code.searchMatrix(matrix, 13));
    }
}
