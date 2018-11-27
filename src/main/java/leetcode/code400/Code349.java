package leetcode.code400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2018/11/28 19:12
 */
public class Code349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        return nums1.length >= nums2.length
                ? part(nums2, nums1) : part(nums1, nums2);
    }

    private int[] part(int[] st, int[] lg) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(st).forEach(set::add);

        Set<Integer> res = new HashSet<>();
        Arrays.stream(lg).forEach(item -> {
            if (set.contains(item)) {
                res.add(item);
            }
        });

        int[] resArray = new int[res.size()];
        int index = 0;
        for (int i : res) {
            resArray[index++] = i;
        }

        return resArray;
    }
}
