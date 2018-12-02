package leetcode.code500;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/2 15:18
 */

public class Code453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
            res += i;
        }

        return res - min * nums.length;
    }

    public static void main(String[] args) {
        Code453 code = new Code453();
        System.out.println(code.minMoves(new int[]{1, 2, 3}));
    }
}
