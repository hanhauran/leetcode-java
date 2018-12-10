package leetcode.code600;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/9 19:48
 */

public class Code557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 1) {
                continue;
            }
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(words).forEach(item -> builder.append(item).append(" "));
        return builder.length() == s.length() ? builder.toString() : builder.substring(0, builder.length() - 1);
    }
}
