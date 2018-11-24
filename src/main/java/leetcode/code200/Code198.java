package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code198 {
    public int rob(int[] nums) {
        // f(n) = Max( f(n-2) + n, f(n-1) )

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxs = new int[nums.length + 1];
        maxs[0] = 0;
        maxs[1] = nums[0];

        int max = maxs[1];

        for (int i = 2; i < maxs.length; i++) {
            maxs[i] = Math.max(maxs[i - 2] + nums[i - 1], maxs[i - 1]);
            if (max < maxs[i]) {
                max = maxs[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Code198 code = new Code198();
        System.out.println(code.rob(nums));
    }
}
