package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/6 21:10
 */

@Level(Levels.MEDIUM)
@Method(Methods.MATH)
@Question("给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。")
public class Code29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        boolean negative = dividend > 0 ^ divisor > 0;

        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);

        long res = 0;
        while (dd != 0) {
            long[] tmp = helper(dd, dr);
            res += tmp[0];
            dd -= tmp[1];
        }

        return negative ? (int) -res : (int) res;
    }

    private long[] helper(long dd, long dr) {
        if (dd < dr) {
            return new long[]{0, dd};
        }

        int res = 1;
        while (true) {
            dr = dr << 1;
            if (dd >= dr) {
                res *= 2;
            } else {
                break;
            }
        }
        return new long[]{res, dr >> 1};
    }

    public static void main(String[] args) {
        Code29 code = new Code29();
        System.out.println(code.divide(7, -3));
    }
}
