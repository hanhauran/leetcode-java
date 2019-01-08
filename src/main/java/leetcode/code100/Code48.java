package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/8 20:26
 */

@Level(Levels.MEDIUM)
@Question("把 n * n 图像顺时针旋转90度")
@Method(Methods.MATH)
public class Code48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                rotateItem(matrix, i, j);
            }
        }
    }

    private void rotateItem(int[][] matrix, int x0, int y0) {
        int x1, y1, x2, y2, x3, y3;
        x1 = y0;
        y1 = matrix.length - 1 - x0;
        x2 = y1;
        y2 = matrix.length - 1 - x1;
        x3 = y2;
        y3 = matrix.length - 1 - x2;
        System.out.println(x0 + " " + y0 + " " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3);
        int tmp = matrix[x0][y0];
        matrix[x0][y0] = matrix[x3][y3];
        matrix[x3][y3] = matrix[x2][y2];
        matrix[x2][y2] = matrix[x1][y1];
        matrix[x1][y1] = tmp;
    }

    public static void main(String[] args) {
        Code48 code = new Code48();
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        code.rotate(matrix);
    }
}
