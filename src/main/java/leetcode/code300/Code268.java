package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
