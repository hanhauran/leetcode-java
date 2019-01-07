package leetcode.code100;

import algorithms.KSum;
import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/7 19:12
 */

@Level(Levels.MEDIUM)
@Question("给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。")
public class Code40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                sum = i;
                break;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            if (i == 1) {
                if (Arrays.binarySearch(candidates, target) >= 0) {
                    res.add(Collections.singletonList(target));
                }
            } else {
                res.addAll(KSum.get(candidates, target, 0, i));
            }
        }
        return res;
    }
}
