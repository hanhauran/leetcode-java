package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 21:00
 */

@Level(Levels.EASY)
public class Code849 {
    public int maxDistToClosest(int[] seats) {
        int left = -1, right = 0;
        int len = -1;
        int tmp;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                right = i;
                tmp = helper(left, i, seats);
                if (tmp > len) {
                    len = tmp;
                }
                left = right;
            }
        }
        if (right != seats.length - 1) {
            tmp = helper(left, -1, seats);
            if (tmp > len) {
                len = tmp;
            }
        }

        return len;
    }

    private int helper(int left, int right, int[] seats) {
        if (left == -1) {
            return right;
        }

        if (right == -1) {
            return seats.length - 1 - left;
        }

        int mid = left + (right - left) / 2;
        return Math.min(mid - left, right - mid);
    }

    public static void main(String[] args) {
        Code849 code = new Code849();
        System.out.println(code.maxDistToClosest(new int[]{0,1,0,1,0}));
    }
}
