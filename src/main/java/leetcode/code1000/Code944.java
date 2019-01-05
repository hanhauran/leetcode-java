package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 14:00
 */

@Level(Levels.EASY)
public class Code944 {
    public int minDeletionSize(String[] a) {
        int res = 0;
        for (int i = 0; i < a[0].length(); i++) {
            res += helper(a, i) ? 0 : 1;
        }
        return res;
    }

    private boolean helper(String[] a, int offset) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1].charAt(offset) < a[i].charAt(offset)) {
                return false;
            }
        }
        return true;
    }
}
