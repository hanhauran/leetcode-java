package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/4 20:22
 */

@Level(Levels.EASY)
public class Code896 {
    public boolean isMonotonic(int[] a) {
        if (a.length <= 2) {
            return true;
        }

        Boolean asc = null;
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = a[i + 1] - a[i];

            if (tmp != 0) {
                if (asc == null) {
                    asc = tmp > 0;
                } else {
                    if (asc && tmp < 0) {
                        return false;
                    } else if (! asc && tmp > 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
