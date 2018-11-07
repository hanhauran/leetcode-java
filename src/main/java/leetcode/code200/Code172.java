package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code172 {
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n != 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
}
