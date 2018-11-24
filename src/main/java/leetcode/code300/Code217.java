package leetcode.code300;

import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
