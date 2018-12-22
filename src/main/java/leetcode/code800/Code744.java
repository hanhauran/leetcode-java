package leetcode.code800;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/22 13:24
 */

public class Code744 {
    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return letters[left % letters.length];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        return helper(letters, (char) (target + 1));
    }

    private char helper(char[] letters, char target) {
        Character res = null;
        for (char item : letters) {
            if (item >= target) {
                if (res == null) {
                    res = item;
                } else if (res > item) {
                    res = item;
                }
            }
        }
        if (res == null) {
            return helper(letters, 'a');
        }
        return res;
    }
}
