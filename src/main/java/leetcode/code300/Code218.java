package leetcode.code300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code218 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> window = new HashSet<>();
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (! window.contains(nums[i])) {
                window.add(nums[i]);
                right++;
            } else {
                return true;
            }

            if (right - left > k) {
                window.remove(nums[left]);
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Code218 code = new Code218();
        System.out.println(code.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 3));
    }
}
