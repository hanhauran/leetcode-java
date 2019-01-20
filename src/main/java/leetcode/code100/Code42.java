package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;
import finder.annotation.Unsolved;

/**
 * @author hr.han
 * @date 2019/1/7 19:54
 */

@Level(Levels.HARD)
@Question("https://leetcode-cn.com/problems/trapping-rain-water/ 接雨水")
@Unsolved
public class Code42 {
    public int trap(int[] height) {
        // 纵向分割
        int[] lm = new int[height.length];
        int[] rm = new int[height.length];
        int leftMax = 0, rightMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftMax = lm[i] = Math.max(leftMax, height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = rm[i] = Math.max(rightMax, height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(lm[i], rm[i]) - height[i];
            if (tmp > 0) {
                res += tmp;
            }
        }

        return res;
    }

    @Unsolved
    public int trap2(int[] height) {
        int i = 0, j = height.length - 1;
        int level = 0;
        int res = 0;
        while (i < j) {
            int lower = height[i] > height[j] ? height[j--] : height[i++];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 32));
    }
}
