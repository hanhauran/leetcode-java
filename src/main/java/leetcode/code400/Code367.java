package leetcode.code400;

/**
 * @author hr.han
 * @date 2018/11/28 19:55
 */

public class Code367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        if (num < 4) {
            return false;
        }

        int right = num / 2;
        int left = 1;

        int res = part(left, right, num);
        return res * res == num;
    }

    public int part(int left, int right, int num) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        long tmp = (long) mid * mid;
        if (tmp > num) {
            return part(left, mid, num);
        } else if (tmp < num) {
            return part(mid + 1, right, num);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Code367 code = new Code367();
        System.out.println(code.part(1, 404100, 808201));
        System.out.println(Math.sqrt(808201));
    }
}
