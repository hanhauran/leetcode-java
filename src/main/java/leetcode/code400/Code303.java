package leetcode.code400;

/**
 * @author ihhr
 * @date 2018/11/27
 */

class NumArray {
    private int[] nums;

    private int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        sum();
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }

    private void sum() {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            sums[i] = tmp;
        }
    }
}

public class Code303 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(Integer.toBinaryString(27));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(3));
    }
}
