package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;
import finder.annotation.Unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/16 22:00
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。从小到大输出第 k 个",
        input = "n = 3, k = 3",
        output = "213",
        explanation = "123, 132, 213, 231, 312, 321, 第 3 个为 213"
)
@Unsolved
public class Code60 {
    /**
     * bad method
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<Integer> res = new ArrayList<>();
        recurse(nums, 0, res);
        Collections.sort(res);
        return String.valueOf(res.get(k - 1));
    }

    public void recurse(int[] nums, int offset, List<Integer> res) {
        if (offset == nums.length) {
            int cur = 0;
            for (int i : nums) {
                cur *= 10;
                cur = cur + i;
            }
            res.add(cur);
            return;
        }

        for (int i = offset; i < nums.length; i++) {
            swap(nums, offset, i);
            recurse(nums, offset + 1, res);
            swap(nums, offset, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        Code60 code = new Code60();
        System.out.println(code.getPermutation(4, 1));
    }
}
