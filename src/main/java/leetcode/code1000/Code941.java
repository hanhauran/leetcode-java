package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 13:34
 */

@Level(Levels.EASY)
public class Code941 {
    public boolean validMountainArray(int[] a) {
        int i = 0, j = a.length - 1;

        while (i < a.length - 1) {
            if (a[i + 1] <= a[i]) {
                break;
            } else {
                i++;
            }
        }

        while (j > 0) {
            if (a[j] >= a[j - 1]) {
                break;
            } else {
                j--;
            }
        }

        return i != 0 && j != a.length - 1 && i == j;
    }
}
