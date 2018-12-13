package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/12 18:34
 */

public class Code665 {
    public boolean checkPossibility(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return true;
        }

        if (index == 0) {
            return part(nums, 1);
        }

        if (index == nums.length - 2) {
            return true;
        }

        if (part(nums, index + 2)) {
            if (nums[index] <= nums[index + 2] || (nums[index - 1] <= nums[index + 1] && nums[index + 1] <= nums[index + 2])) {
                return true;
            }
        }

        return false;
    }

    private boolean part(int[] nums, int start) {
        for (int i = start; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code665 code = new Code665();
        System.out.println(code.checkPossibility(new int[]{-1,4,2,3}));
    }
}
