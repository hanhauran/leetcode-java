package leetcode.code300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<Character> tl = new ArrayList<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            tl.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int index = tl.indexOf(character);
            if (index == -1) {
                return false;
            } else {
                tl.remove(index);
            }
        }

        return true;
    }
}
