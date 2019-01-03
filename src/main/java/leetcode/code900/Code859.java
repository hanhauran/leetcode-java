package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/3 9:23
 */

@Level(Levels.EASY)
public class Code859 {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int first = -1, second = -1, count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                switch (count) {
                    case 1: first = i; break;
                    case 2: second = i; break;
                    case 3: return false;
                    default:
                }
            }
        }

        if (count == 0) {
            int[] helper = new int[26];
            for (int i = 0; i < a.length(); i++) {
                helper[a.charAt(i) - 'a']++;
                if (helper[a.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }

        if (count == 1) {
            return false;
        }

        return a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
    }
}
