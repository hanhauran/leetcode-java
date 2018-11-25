package leetcode.code300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code290 {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");

        if (chars.length != strs.length) {
            return false;
        }

        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (! m1.containsKey(chars[i])) {
                m1.put(chars[i], strs[i]);
                if (m2.containsKey(strs[i])) {
                    return false;
                } else {
                    m2.put(strs[i], chars[i]);
                }
            } else {
                if (! m1.get(chars[i]).equals(strs[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
