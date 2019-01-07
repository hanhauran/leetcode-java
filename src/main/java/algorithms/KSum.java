package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/7 19:24
 */

public class KSum {
    /**
     * 返回数组中所有满足和为target且数目为k的list
     * @param nums 已排序数组
     * @param target 目标值
     * @param start 数组起始索引
     * @param k list的大小
     * @return 所有符合条件list
     */
    public static List<List<Integer>> get(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    res.add(tmpList);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                }
            }
        } else {
            for (int i = start; i <= nums.length - k; i++) {
                List<List<Integer>> list = get(nums, target - nums[i], i + 1, k - 1);
                if (! list.isEmpty()) {
                    for (List<Integer> l : list) {
                        l.add(nums[i]);
                    }
                    res.addAll(list);
                }

                while (i <= nums.length - k && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return res;
    }
}
