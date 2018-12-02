package leetcode.code500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2018/12/1 16:38
 */

public class Code447 {
    public int numberOfBoomerangs(int[][] points) {
        int[][] helper = new int[points.length][points.length];
        buildHelper(points, helper);
//        for (int i = 0; i < helper.length; i++) {
//            for (int j = 0; j < helper[0].length; j++) {
//                System.out.print(helper[i][j] + " ");
//            }
//            System.out.println();
//        }
        int res = 0;
        for (int i = 0; i < helper.length; i++) {
            res += num(helper[i]);
        }
        return res;
    }

    private int num(int[] line) {
        Map<Integer, Integer> map = new HashMap<>(line.length * 3 / 4 + 1);
        Arrays.stream(line).forEach(item -> map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1));
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                continue;
            }

            res += entry.getValue() * (entry.getValue() - 1);
        }
        return res;
    }

    private void buildHelper(int[][] points, int[][] helper) {
        for (int i = 0; i < helper.length; i++) {
            for (int j = i + 1; j < helper.length; j++) {
                int tmp = res(points, i, j);
                helper[i][j] = tmp;
                helper[j][i] = tmp;
            }
        }
    }

    private int res(int[][] points, int i, int j) {
        return ((int) Math.pow(points[j][0] - points[i][0], 2)) + ((int) Math.pow(points[j][1] - points[i][1], 2));
    }

    public static void main(String[] args) {
        Code447 code = new Code447();
        System.out.println(code.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0,1}, {0, -1}}));
    }
}
