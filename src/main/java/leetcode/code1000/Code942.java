package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 13:37
 */

@Level(Levels.EASY)
public class Code942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int i = 0, a = n;
        int offset = 0;

        for (char c : s.toCharArray()) {
            if (c == 'I') {
                res[offset++] = i++;
            } else {
                res[offset++] = a--;
            }
        }

        res[offset] = i;
        return res;
    }
}
