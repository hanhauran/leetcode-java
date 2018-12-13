package leetcode.code700;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2018/12/13 12:13
 */

public class Code697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (! map.containsKey(nums[i])) {
                int[] array = new int[3];
                array[0] = 1;
                array[1] = i;
                array[2] = i;
                map.put(nums[i], array);
            } else {
                int[] array = map.get(nums[i]);
                array[0]++;
                array[2] = i;
            }
        }

        int len = Integer.MAX_VALUE;
        int sumMax = Integer.MIN_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] array = entry.getValue();
            if (array[0] > sumMax) {
                sumMax = array[0];
                len = array[2] - array[1] + 1;
            } else if (array[0] == sumMax) {
                len = Math.min(len, array[2] - array[1] + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Code697 code = new Code697();
        System.out.println(code.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
