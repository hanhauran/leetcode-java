package leetcode.code600;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/5 19:58
 */

public class Code506 {
    private static final String GOLD_MEDAL = "Gold Medal";
    private static final String SILVER_MEDAL = "Silver Medal";
    private static final String BRONZE_MEDAL = "Bronze Medal";

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        String[] res = new String[nums.length];
        int count = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == 1) {
                res[entry.getValue()] = GOLD_MEDAL;
            } else if (count == 2) {
                res[entry.getValue()] = SILVER_MEDAL;
            } else if (count == 3) {
                res[entry.getValue()] = BRONZE_MEDAL;
            } else {
                res[entry.getValue()] = String.valueOf(count);
            }
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        Code506 code = new Code506();
        System.out.println(Arrays.toString(code.findRelativeRanks(new int[]{5, 3, 2, 4, 1})));
    }
}
