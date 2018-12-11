package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/11 16:31
 */

public class Code643 {
    public double findMaxAverage(int[] nums, int k) {
        int win = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            win += nums[i];
        }
        max = win;
        for (int i = 1; i <= nums.length - k; i++) {
            win = win - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, win);
        }
        return max * 1.0D / k;
    }

    public static void main(String[] args) {
        Code643 code = new Code643();
        System.out.println(code.findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
}
