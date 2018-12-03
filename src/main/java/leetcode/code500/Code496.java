package leetcode.code500;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/3 14:36
 */

public class Code496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            if (! map.containsKey(nums2[i])) {
                continue;
            }

            result[map.get(nums2[i])] = helper(nums2, i);
        }
        return result;
    }

    private int helper(int[] nums2, int index) {
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[index]) {
                return nums2[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code496 code = new Code496();
        System.out.println(Arrays.toString(code.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
