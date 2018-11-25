package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }

        for (int i = nums.length - 1; i > nums.length - 1 - count; i--) {
            nums[i] = 0;
        }
    }
}
