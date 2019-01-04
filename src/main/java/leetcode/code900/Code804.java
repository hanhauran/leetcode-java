package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/2 14:49
 */

@Level(Levels.EASY)
public class Code804 {
    private static final String[] MO = {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        final Set<String> set = new HashSet<>();
//        Arrays.stream(words).forEach(word -> {
//            set.add(build(word));
//        });
        for (String word : words) {
            set.add(build(word));
        }
        return set.size();
    }

    private String build(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(MO[c - 'a']);
        }
        return builder.toString();
    }
}
