package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/3 16:25
 */

@Level(Levels.EASY)
public class Code884 {
    public String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> map = new HashMap<>();
        helper(a, map);
        helper(b, map);

        Set<String> set = new HashSet<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                set.add(entry.getKey());
            }
        }
        String[] result = new String[set.size()];
        return set.toArray(result);
    }

    private void helper(String a, Map<String, Integer> map) {
        String[] aWords = a.split(" ");
//        Arrays.stream(aWords).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        for (String word : aWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}
