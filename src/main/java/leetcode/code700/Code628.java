package leetcode.code700;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/11 15:57
 */

public class Code628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
