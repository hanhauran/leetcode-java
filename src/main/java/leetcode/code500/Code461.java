package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 9:57
 */

public class Code461 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            count += tmp & 1;
            tmp >>= 1;
        }
        return count;
    }
}
