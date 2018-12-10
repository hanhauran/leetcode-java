package leetcode.code600;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/10 14:14
 */

public class Code561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
