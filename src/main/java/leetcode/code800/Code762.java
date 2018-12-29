package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/29 14:36
 */

public class Code762 {
    private static final boolean[] HELPER = {
            false, false, true, true,
            false, true, false, true,
            false, false, false, true,
            false, true, false, false,
            false, true, false, true,
            false, false, false, true,
            false, false, false, false,
            false, true, false, true
    };

    public int countPrimeSetBits(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += (HELPER[Integer.bitCount(i)] ? 1 : 0);
        }
        return res;
    }
}
