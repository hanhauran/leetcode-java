package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/2 19:24
 */

@Level(Levels.EASY)
public class Code821 {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();

        int left = -1, right = 0;
        for (int i = 0; i < result.length; i++) {
            if (chars[i] == c) {
                right = i;
                helper(chars, left, right, result);
                left = right;
            }
        }
        if (right != result.length) {
            helper(chars, left, -1, result);
        }
        return result;
    }

    private void helper(char[] chars, int left, int right, int[] result) {
        int len = 0;

        if (left == -1) {
            while (right >= 0) {
                result[right--] = len++;
            }
            return;
        }

        if (right == -1) {
            while (left < result.length) {
                result[left++] = len++;
            }
            return;
        }

        while (left <= right) {
            result[left++] = len;
            result[right--] = len++;
        }
    }

    public static void main(String[] args) {
        Code821 code = new Code821();
        System.out.println(Arrays.toString(code.shortestToChar("loveleetcode", 'e')));
    }
}
