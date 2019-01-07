package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/6 13:23
 */

@Level(Levels.MEDIUM)
@Question("三数之和")
public class Code16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int tmp = helper(nums, i, target - nums[i]) + nums[i];
            if (Math.abs(tmp - target) < Math.abs(res - target)) {
                res = tmp;
            }
        }

        return res;
    }

    private int helper(int[] nums, int offset, int target) {
        int i = offset + 1, j = nums.length - 1;
        int sum = nums[i] + nums[j];
        int res = sum;
        int sign = sum - target;
        while (i + 1 < j) {
            if (sign > 0) {
                sum = sum - nums[j] + nums[--j];
                if (Math.abs(sum - target) < Math.abs(sign)) {
                    res = sum;
                }
                sign = sum - target;
            } else {
                sum = sum - nums[i] + nums[++i];
                if (Math.abs(sum - target) < Math.abs(sign)) {
                    res = sum;
                }
                sign = sum - target;
            }

            if (sign == 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Code16 code = new Code16();
        System.out.println(code.threeSumClosest(new int[]{-5,-5,-4,0,0,3,3,4,5}, -2));
    }
}
