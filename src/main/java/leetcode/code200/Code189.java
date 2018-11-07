package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code189 {
    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            k -= nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        if (k < nums.length) {
            reverse(nums, k, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
