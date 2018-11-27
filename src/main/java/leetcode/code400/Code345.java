package leetcode.code400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2018-11-28 18:50:01
 */

public class Code345 {

    private static final Set<Character> SET = new HashSet<>();
    static {
        SET.add('a');
        SET.add('A');
        SET.add('e');
        SET.add('E');
        SET.add('i');
        SET.add('I');
        SET.add('o');
        SET.add('O');
        SET.add('u');
        SET.add('U');
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (! SET.contains(chars[i])) {
                i++;
            } else if (! SET.contains(chars[j])) {
                j--;
            } else {
                swap(chars, i++, j--);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    public static void main(String[] args) {
        Code345 code = new Code345();
        System.out.println(code.reverseVowels("leetcode"));
    }
}
