package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 14:06
 */

public class Code485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int left = -1, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                max = Math.max(max, right - left - 1);
                left = right;
            }
            right++;
        }

        return Math.max(max, right - left - 1);
    }

    public static void main(String[] args) {
        Code485 code = new Code485();
        System.out.println(code.findMaxConsecutiveOnes(new int[]{1}));
    }
}
