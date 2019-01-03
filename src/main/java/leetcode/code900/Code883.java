package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2019/1/3 15:55
 */

@Level(Levels.EASY)
public class Code883 {
    public int projectionArea2(int[][] grid) {
        int areaXY = 0, areaYZ = 0, areaXZ = 0;
        int maxX = 0;
        int[] maxY = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                areaXY += grid[i][j] > 0 ? 1 : 0;
                maxX = Math.max(maxX, grid[i][j]);
                maxY[j] = Math.max(maxY[j], grid[i][j]);
            }
            areaXZ += maxX;
            maxX = 0;
        }

        for (int i : maxY) {
            areaYZ += i;
        }
        return areaXY + areaYZ + areaXZ;
    }

    public int projectionArea(int[][] grid) {
        return helper(grid, 0) + helper(grid, 1) + helper(grid, 2);
    }

    private int helper(int[][] grid, int a) {
        int res = 0;
        if (a == 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    res += grid[i][j] > 0 ? 1 : 0;
                }
            }
            return res;
        } else {
            return helper2(grid, a);
        }
    }

    private int helper2(int[][] grid, int a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int key = a == 1 ? i : j;
                map.put(key, Math.max(map.getOrDefault(key, 0), grid[i][j]));
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        Code883 code = new Code883();
        System.out.println(code.projectionArea2(new int[][]{{1, 4}, {1, 1}}));
    }
}
