package leetcode.code600;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/11 13:56
 */

public class Code594 {
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                max = Math.max(max, part(nums, i));
            }
        }

        return max;
    }

    private int part(int[] nums, int index) {
        int val = nums[index] + 1;
        int i;
        for (i = index + 1; i < nums.length; i++) {
            if (nums[i] > val) {
                if (nums[i - 1] == val) {
                    return i - index;
                } else {
                    return 0;
                }
            }
        }
        if (nums[nums.length - 1] - 1 == nums[index]) {
            return nums.length - index;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Code594 code = new Code594();
        System.out.println(code.findLHS(new int[]{1, 1, 1, 1}));
    }
}
