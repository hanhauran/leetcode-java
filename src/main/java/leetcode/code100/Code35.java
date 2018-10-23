package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code35 {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        return searchPart(nums, 0, nums.length - 1, target);
    }

    private int searchPart(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return right;
        }

        int mid = (left + right) / 2;

        if (target > nums[mid]) {
            return searchPart(nums, mid + 1, right, target);
        } else if (target < nums[mid]) {
            return searchPart(nums, left, mid, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Code35 code = new Code35();
        int[] nums = {1,3,5,6};
        System.out.println(code.searchInsert(nums, 7));
    }
}
