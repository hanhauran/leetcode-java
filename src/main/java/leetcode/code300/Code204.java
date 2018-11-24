package leetcode.code300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/11/24
 *
 * unknown bug
 */

public class Code204 {

    private static final List<Integer> primes = new ArrayList<>();
    static {
        primes.add(2);
    }

    public int countPrimes(int n) {
        expand(n);
        int count = 0;
        for (Integer prime : primes) {
            if (prime < n) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private void expand(int n) {
        if (primes.get(primes.size() - 1) > Math.sqrt(n)) {
            return;
        }

        for (int i = primes.get(primes.size() - 1) + 1; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private boolean isPrime(int n) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return false;
            }

            if (Math.sqrt(n) < prime) {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code204 code = new Code204();
        System.out.println(code.countPrimes(12));
        System.out.println(primes);
    }
}
