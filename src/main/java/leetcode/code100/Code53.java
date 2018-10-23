package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code53 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayPart(nums, 0, nums.length - 1);
    }

    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int index = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (index < 0) {
                index = nums[i];
            } else {
                index += nums[i];
            }

            if (sum < index) {
                sum = index;
            }
        }

        return sum;
    }

    private int maxSubArrayPart(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int index;
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE, maxCenter;

        int tmp = 0;
        for (index = mid; index >= left; index--) {
            tmp += nums[index];
            if (tmp > maxLeft) {
                maxLeft = tmp;
            }
        }

        tmp = 0;
        for (index = mid; index <= right; index++) {
            tmp += nums[index];
            if (tmp > maxRight) {
                maxRight = tmp;
            }
        }

        maxCenter = maxLeft + maxRight - nums[mid];
        int max = Math.max(Math.max(maxLeft, maxRight), maxCenter);
        int leftMax = maxSubArrayPart(nums, left, mid);
        int rightMax = maxSubArrayPart(nums, mid + 1, right);

        return Math.max(Math.max(leftMax, rightMax), max);
    }

    public static void main(String[] args) {
        Code53 code = new Code53();
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(code.maxSubArray2(array));
    }
}
