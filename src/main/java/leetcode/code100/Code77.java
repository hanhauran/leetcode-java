package leetcode.code100;

import algorithms.NmTaker;
import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Link;
import finder.annotation.Question;

import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/19 19:35
 */

@Level(Levels.MEDIUM)
@Question("给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。")
@Link(NmTaker.class)
public class Code77 {
    public List<List<Integer>> combine(int n, int k) {
        return NmTaker.take(n, k);
    }
}
