package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code263 {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }

        return true;
    }
}
