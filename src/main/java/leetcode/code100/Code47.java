package leetcode.code100;

import algorithms.FullyArranger;
import finder.annotation.*;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/8 19:43
 */

@Level(Levels.MEDIUM)
@Question("全排序，有重复元素")
@Method({Methods.RECURSE, Methods.BFS})
public class Code47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return FullyArranger.arrange(nums, true);
    }

    public static void main(String[] args) {
        Code47 code = new Code47();
        System.out.println(code.permuteUnique(new int[]{1, 1, 2}));
    }
}
