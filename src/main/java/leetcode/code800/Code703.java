package leetcode.code800;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/13 12:31
 */

public class Code703 {
    private static class KthLargest {
        private int[] array;
        private int offset;

        public KthLargest(int k, int[] nums) {
            array = new int[k];
            offset = 0;
            Arrays.sort(nums);
            if (nums.length < k) {
                for (int i = nums.length - 1; i >= 0; i--) {
                    array[offset++] = nums[i];
                }
            } else {
                for (int i = nums.length - 1; i >= nums.length - k; i--) {
                    array[offset++] = nums[i];
                }
            }
        }

        public int add(int val) {
            if (offset < array.length) {
                array[offset++] = val;
            } else {
                if (val > array[offset - 1]) {
                    array[offset - 1] = val;
                }
            }
            for (int i = offset - 1; i >= 1; i--) {
                if (array[i] > array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            return array[offset - 1];
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}
