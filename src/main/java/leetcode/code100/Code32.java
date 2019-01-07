package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

/**
 * @author hr.han
 * @date 2019/1/7 10:42
 */

@Level(Levels.HARD)
@Question("给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。")
public class Code32 {
    public int longestValidParentheses(String s) {
        int tmp1 = helper(s.toCharArray());
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        for (i = 0; i < chars.length; i++) {
            chars[i] = (chars[i] == '(') ? ')' : '(';
        }
        return Math.max(tmp1, helper(chars));
    }

    private int helper(char[] chars) {
        int left = 0, right = 0;
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left > right) {
                tmp++;
            } else if (left < right) {
                tmp = 0;
                left = 0;
                right = 0;
            } else {
                tmp++;
                res = Math.max(res, tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Code32 code = new Code32();
        System.out.println(code.longestValidParentheses("(()"));
    }
}
