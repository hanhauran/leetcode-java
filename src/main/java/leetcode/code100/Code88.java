package leetcode.code100;

import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;

        int index = m + n + 1;
        while (index >= 0) {
            if (m < 0) {
                System.arraycopy(nums2, 0, nums1, 0, n + 1);
                break;
            }
            if (n < 0) {
                break;
            }

            if (nums1[m] >= nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Code88 code = new Code88();
        code.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
