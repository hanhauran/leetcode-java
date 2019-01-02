package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/2 18:44
 */

@Level(Levels.EASY)
public class Code812 {
    public double largestTriangleArea(int[][] points) {
        double res = Double.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    res = Math.max(res, helper(points, i, j, k));
                }
            }
        }
        return res;
    }

    private double helper(int[][] points, int index1, int index2, int index3) {
//        return (points[index2][0] - points[index1][0]) * (points[index3][1] - points[index1][1])
//                - (points[index3][0] - points[index1][0]) * (points[index2][1] - points[index1][1]);
        double a = Math.sqrt(Math.pow(points[index1][0] - points[index2][0], 2) + Math.pow(points[index1][1] - points[index2][1], 2));
        double b = Math.sqrt(Math.pow(points[index1][0] - points[index3][0], 2) + Math.pow(points[index1][1] - points[index3][1], 2));
        double c = Math.sqrt(Math.pow(points[index2][0] - points[index3][0], 2) + Math.pow(points[index2][1] - points[index3][1], 2));
        double p = (a + b + c) / 2;
        return Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c)));
    }

    public static void main(String[] args) {
        Code812 code = new Code812();
        int[][] array = {
                {35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}
        };
        System.out.println(code.largestTriangleArea(array));
    }
}
