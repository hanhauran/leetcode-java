package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 19:40
 */

@Level(Levels.EASY)
public class Code824 {
    public String toGoatLatin(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }

            char tmp = Character.toLowerCase(word.charAt(0));
            if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') {
                builder.append(word).append("ma");
            } else {
                builder.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }

            int cur = i;
            while (cur != -1) {
                builder.append('a');
                cur--;
            }
            builder.append(' ');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
