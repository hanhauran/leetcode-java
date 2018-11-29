package leetcode.code400;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/11/29 9:54
 */

public class Code389 {
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        int i = 0;
        while (i < s.length()) {
            if (sc[i] == tc[i]) {
                i++;
            } else {
                break;
            }
        }

        return tc[i];
    }

    public char findTheDifference2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int res = 0;
        for (char tmp : sc) {
            res ^= tmp;
        }
        for (char tmp : tc) {
            res ^= tmp;
        }

        return (char) res;
    }

    public static void main(String[] args) {
        Code389 code = new Code389();
        System.out.println(code.findTheDifference2("abcd", "abcde"));
    }
}
