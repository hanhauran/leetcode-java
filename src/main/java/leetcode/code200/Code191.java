package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }
}
