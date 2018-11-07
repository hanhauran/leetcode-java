package leetcode.code200;

import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp > target) {
                right--;
            } else if (tmp < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Code167 code = new Code167();
        System.out.println(Arrays.toString(code.twoSum(new int[]{2, 3, 6, 8, 11, 15}, 9)));
    }
}
