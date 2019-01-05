package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 15:03
 */

@Level(Levels.EASY)
public class Code961 {
    public int repeatedNTimes(int[] a) {
        int[] helper = new int[10000];

        for (int i : a) {
            helper[i]++;
            if (helper[i] > 1) {
                return i;
            }
        }

        return -1;
    }
}
