package leetcode.code100;

import algorithms.FullyArranger;
import finder.annotation.*;

import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/8 15:34
 */

@Level(Levels.MEDIUM)
@Question("全排列，无重复元素")
@Method({Methods.BFS, Methods.RECURSE})
public class Code46 {
    public List<List<Integer>> permute(int[] nums) {
        return FullyArranger.arrange(nums);
    }

    public static void main(String[] args) {
        Code46 code = new Code46();
        System.out.println(code.permute(new int[]{1, 2, 3}));
    }
}
