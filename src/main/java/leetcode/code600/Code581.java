package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/10 15:37
 */

public class Code581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int beg = -1;
        int end = -2;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (max > nums[i]) {
                end = i;
            }
            if (min < nums[len - i - 1]) {
                beg = len - i - 1;
            }
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        Code581 code = new Code581();
        System.out.println(code.findUnsortedSubarray(new int[]{2,1}));
    }
}
