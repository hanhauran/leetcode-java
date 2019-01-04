package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/4 21:16
 */

@Level(Levels.EASY)
public class Code917 {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (! Character.isLetter(chars[left])) {
                left++;
            } else if (! Character.isLetter(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
        return new String(chars);
    }
}
