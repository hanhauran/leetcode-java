package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 20:57
 */

@Level(Levels.EASY)
public class Code844 {
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c != '#') {
                builder.append(c);
            } else {
                if (builder.length() != 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return builder.toString();
    }
}
