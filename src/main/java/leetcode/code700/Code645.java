package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/11 16:52
 */

public class Code645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] helper = new int[nums.length + 1];
        for (int i : nums) {
            helper[i]++;
            if (helper[i] == 2) {
                result[0] = i;
            }
        }
        for (int i = 1; i < helper.length; i++) {
            if (helper[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
