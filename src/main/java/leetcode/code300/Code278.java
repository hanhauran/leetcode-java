package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code278 {

    private boolean isBadVersion(int version) {
        return Math.random() >= 0.5D;
    }

    public int firstBadVersion(int n) {
        return part(1, n);
    }

    private int part(int left, int right) {
        if (left == right || left + 1 == right) {
            return isBadVersion(left) ? left : left + 1;
        }

        int mid = left + (right - left) / 2;

        if (isBadVersion(mid)) {
            return part(left, mid);
        } else {
            return part(mid + 1, right);
        }
    }

}
