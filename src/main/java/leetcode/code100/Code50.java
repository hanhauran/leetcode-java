package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/9 15:28
 */

@Level(Levels.MEDIUM)
@Question("实现 pow(x, n)")
@Method(Methods.MATH)
public class Code50 {
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1D;
        }

        if (x == 0D) {
            return 0D;
        }

        return n < 0 ? 1 / recurse(x, -n) : recurse(x, n);
    }

    private double recurse(double x, int n) {
        if (n == 0) {
            return 1D;
        } else if (n == 1) {
            return x;
        } else if (n == 2) {
            return x * x;
        }

        double res = recurse(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1D;
        }

        if (x == 0D) {
            return 0D;
        }

        boolean negative = n < 0;
        n = Math.abs(n);

        double res = 1D;
        while (n != 0) {
            int m = ((int) (Math.log(n) / Math.log(2)));
            int tmp = m;
            double tmpRes = x;
            while (tmp != 0) {
                tmpRes = tmpRes * tmpRes;
                tmp--;
            }
            res *= tmpRes;
            n -= 1 << m;
        }

        return negative ? 1D / res : res;
    }

    public static void main(String[] args) {
        Code50 code = new Code50();
        System.out.println(code.myPow2(2, 4));
    }
}
