package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/12 20:42
 */

public class Code674 {
    public int findLengthOfLCIS(int[] nums) {
        int cur = -1;
        int len = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                len = Math.max(len, i - cur);
                cur = i;
            }
        }
        len = Math.max(len, nums.length - 1 - cur);
        return len;
    }

    public static void main(String[] args) {
        Code674 code = new Code674();
        System.out.println(code.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
