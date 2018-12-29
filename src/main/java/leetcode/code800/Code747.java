package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/28 16:54
 */

public class Code747 {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int fmax = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        int findex = -1, sindex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > fmax) {
                smax = fmax;
                sindex = findex;
                fmax = nums[i];
                findex = i;
            } else {
                if (nums[i] > smax) {
                    smax = nums[i];
                    sindex = i;
                }
            }
        }

        if (smax == 0) {
            return findex;
        }

        return fmax / smax >= 2 ? findex : -1;
    }

    public static void main(String[] args) {
        Code747 code = new Code747();
        System.out.println(code.dominantIndex(new int[]{-1, 6, -1, 0}));
    }
}
