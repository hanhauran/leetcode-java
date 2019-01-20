package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/8 16:59
 */

public class NmTaker {
    public static List<List<Integer>> take(int[] nums, int t) {
        if (nums == null || nums.length == 0 || nums.length < t) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        recurse(nums,0, t, new ArrayList<>(), res);
        return res;
    }

    private static void recurse(int[] nums, int offset, int take, List<Integer> tmp, List<List<Integer>> res) {
        if (take == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (offset >= nums.length) {
            return;
        }
        // solution 1
//        tmp.add(nums[offset]);
//        recurse(nums, offset + 1, take - 1, tmp, res);
//        tmp.remove(tmp.size() - 1);
//        recurse(nums, offset + 1, take, tmp, res);

        // solution 2
        for (int i = offset; i <= nums.length - take; i++) {
            tmp.add(nums[i]);
            recurse(nums, i + 1, take - 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static List<List<Integer>> take(int n, int k) {
        if (n == 0 || k == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        recurse(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private static void recurse(int offset, int left, int n, List<Integer> tmp, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (offset > n) {
            return;
        }

        for (int i = offset; i <= n - left + 1; i++) {
            tmp.add(i);
            recurse(i + 1, left - 1, n, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(NmTaker.take(new int[]{1, 2, 3, 4}, 2));
        System.out.println(NmTaker.take(new int[]{1, 2, 3, 4}, 2).size());
        System.out.println(NmTaker.take(4, 2));
    }
}
