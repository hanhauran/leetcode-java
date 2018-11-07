package leetcode.code200;

import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code169 {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int tmp : nums) {
//            map.put(tmp, map.containsKey(tmp) ? map.get(tmp) + 1 : 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > (nums.length / 2)) {
//                return entry.getKey();
//            }
//        }
//        return 0;
    }
}
