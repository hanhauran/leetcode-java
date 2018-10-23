package leetcode.code100;

import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Code27 code = new Code27();
        int[] nums = {3,3};
        int val = 3;
        System.out.println(code.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
