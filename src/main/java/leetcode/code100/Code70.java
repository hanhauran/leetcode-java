package leetcode.code100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code70 {
    public int climbStairs(int n) {
        int mid = n / 2;
        int result = 0;
        for (int i = 0; i <= mid; i++) {
            result += choose(n - i, i);
        }
        return result;
    }

    private static final List<Integer> cache = new ArrayList<>();
    static {
        cache.add(1);
        cache.add(2);
    }
    public int climbStairs2(int n) {
        if (cache.size() >= n) {
            return cache.get(n - 1);
        }

        for (int i = cache.size(); i <= n; i++) {
            cache.add(cache.get(i - 1) + cache.get(i - 2));
        }

        return cache.get(n - 1);
    }

    private int choose(int sum, int cho) {
        if (cho == 0) {
            return 1;
        }

        if (cho >= sum / 2) {
            cho = sum - cho;
        }

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < cho; i++) {
            result = result.multiply(BigInteger.valueOf(sum));
            sum--;
        }
        int tmp = cho;
        for (int i = 0; i < cho; i++) {
            result = result.divide(BigInteger.valueOf(tmp));
            tmp--;
        }
        return result.intValue();
    }

    public static void main(String[] args) {
        Code70 code = new Code70();
        System.out.println(code.climbStairs(35));
        System.out.println(code.climbStairs2(35));
    }
}
