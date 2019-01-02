package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/2 19:11
 */

@Level(Levels.EASY)
public class Code819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        String[] words = paragraph.toLowerCase().split("[^a-zA-Z0-9]");
        Map<String, Integer> map = new HashMap<>();

//        Arrays.stream(words).forEach(item -> {
//            if (! item.isEmpty() && ! set.contains(item)) {
//                map.put(item, map.getOrDefault(item, 0) + 1);
//            }
//        });
        for (String word : words) {
            if (! word.isEmpty() && ! set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int times = 0;
        String word = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times) {
                times = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }

    public static void main(String[] args) {
        Code819 code = new Code819();
        System.out.println(code.mostCommonWord("Bob hit a ball, the hit BALL. flew far after it was hit.", new String[]{"hit"}));
    }
}
