package leetcode.code100;

import algorithms.KSum;
import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/6 13:55
 */

@Level(Levels.MEDIUM)
@Question("四数之和")
public class Code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        return KSum.get(nums, target, 0, 4);
    }
}
