package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/14 21:09
 */

public class Code724 {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }

        int index = 0;
        int lsum = 0, rsum = 0;
        for (int i = index + 1; i < nums.length; i++) {
            rsum += nums[i];
        }

        while (index < nums.length - 1) {
            if (lsum == rsum) {
                return index;
            } else {
                lsum += nums[index++];
                rsum -= nums[index];
            }
        }

        return lsum == rsum ? index : -1;
    }

    public static void main(String[] args) {
        Code724 code = new Code724();
        System.out.println(code.pivotIndex(new int[]{-1, -1, 0, 1, 1, 0}));
    }
}
