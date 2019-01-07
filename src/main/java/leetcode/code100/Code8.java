package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 17:12
 */

@Level(Levels.MEDIUM)
public class Code8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        boolean positive = true;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            positive = str.charAt(0) != '-';
            str = str.substring(1);
        }

        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                res = positive
                        ? res * 10 + Character.digit(str.charAt(i), 10)
                        : res * 10 - Character.digit(str.charAt(i), 10);
                if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                    res = positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    break;
                }
            } else {
                break;
            }
        }

        return (int) res;
    }
}
