package leetcode.code500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2018/11/30 15:50
 */

public class Code409 {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        int len = 0;
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                len += entry.getValue();
            } else {
                if (flag) {
                    len += entry.getValue();
                    flag = false;
                } else {
                    len += entry.getValue() - 1;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Code409 code = new Code409();
        System.out.println(code.longestPalindrome("abccccdd"));
    }
}
