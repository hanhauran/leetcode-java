package leetcode.code400;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/11/28 19:23
 */

public class Code350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] resArray = new int[res.size()];
        i = 0;
        for (int r : res) {
            resArray[i++] = r;
        }

        return resArray;
    }
}
