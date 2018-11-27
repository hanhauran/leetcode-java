package leetcode.code400;

import java.util.Random;

/**
 * @author hr.han
 * @date 2018/11/28 20:37
 */

public class Code374 {
    public int guessNumber(int n) {
        return part(1, n);
    }

    private int part(int left, int right) {
        int mid = left + (right - left) / 2;
        int res = guess(mid);
        if (res == 0) {
            return mid;
        } else if (res == 1) {
            return part(mid + 1, right);
        } else {
            return part(left, mid);
        }
    }

    public int guessNumber2(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            } else if (tmp == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static final int[] ints = {1, 0, -1};
    private static final Random rand = new Random();
    private int guess(int num) {
        return ints[rand.nextInt(3)];
    }

    public static void main(String[] args) {
        Code374 code = new Code374();
        System.out.println(code.guessNumber(10));
    }
}
