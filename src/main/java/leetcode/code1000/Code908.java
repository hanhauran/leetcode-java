package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/4 20:47
 */

@Level(Levels.EASY)
public class Code908 {
    public int smallestRangeI(int[] a, int k) {
        if (k < 0) {
            return smallestRangeI(a, -k);
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : a) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int res = max - min - 2 * k;

        return res > 0 ? res : 0;
    }
}
