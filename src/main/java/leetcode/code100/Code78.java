package leetcode.code100;

import algorithms.NmTaker;
import finder.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/19 20:24
 */

@Level(Levels.MEDIUM)
@Question("给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集 | 大小从 0 到 nums.length）。")
@Link(NmTaker.class)
@Method({Methods.BFS, Methods.DFS, Methods.RECURSE})
public class Code78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void recurse(int[] nums, int offset, List<Integer> tmp, List<List<Integer>> res) {
        res.add(new ArrayList<>(tmp));

        for (int i = offset; i < nums.length; i++) {
            tmp.add(nums[i]);
            recurse(nums, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code78 code = new Code78();
        System.out.println(code.subsets(new int[]{1, 2, 3}));
    }
}
