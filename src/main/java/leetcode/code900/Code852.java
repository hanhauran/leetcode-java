package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 21:25
 */

@Level(Levels.EASY)
public class Code852 {
    public int peakIndexInMountainArray(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                return i;
            }
        }
        return -1;
    }
}
