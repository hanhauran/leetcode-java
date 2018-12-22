package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/13 15:17
 */

public class Code704 {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return nums[left] == target ? left : -1;
        }
//        if (left + 1 >= right) {
//            if (nums[left] == target) {
//                return left;
//            } else if (nums[right] == target) {
//                return right;
//            } else {
//                return -1;
//            }
//        }

        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            return helper(nums, mid + 1, right, target);
        } else if (nums[mid] == target) {
            return mid;
        } else {
            return helper(nums, left, mid, target);
        }
    }

    public static void main(String[] args) {
        Code704 code = new Code704();
        System.out.println(code.search(new int[]{-1, 0}, -2));
    }
}
