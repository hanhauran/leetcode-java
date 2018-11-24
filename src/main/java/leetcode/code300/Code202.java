package leetcode.code300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (true) {
            n = res(n);
            if (n == 1) {
                return true;
            }

            if (! set.contains(n)) {
                set.add(n);
            } else {
                return false;
            }
        }
    }

    private int res(int n) {
        int result = 0;
        int tmp;
        while (n != 0) {
            tmp = n % 10;
            result += tmp * tmp;
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Code202 code = new Code202();
        System.out.println(code.isHappy(19));
    }
}
