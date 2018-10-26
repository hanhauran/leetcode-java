package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/10/26
 */

public class Code136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Code136 code = new Code136();
        System.out.println(code.singleNumber(new int[]{2, 2, 1}));
    }
}
