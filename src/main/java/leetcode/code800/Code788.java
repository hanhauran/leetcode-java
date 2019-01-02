package leetcode.code800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/2 14:15
 */

public class Code788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += helper(i) ? 1 : 0;
        }
        return count;
    }

    private static final Set<Integer> SET1 = new HashSet<>(8);
    private static final Set<Integer> SET2 = new HashSet<>(8);
    static {
        SET1.add(0);
        SET1.add(1);
        SET1.add(8);
        SET2.add(2);
        SET2.add(5);
        SET2.add(6);
        SET2.add(9);
    }

    private boolean helper(int cur) {
        boolean flag2 = false;
        while (cur != 0) {
            int tmp = cur % 10;
            if (SET2.contains(tmp)) {
                flag2 = true;
            } else if (! SET1.contains(tmp)) {
                return false;
            }
            cur = cur / 10;
        }

        return flag2;
    }
}
