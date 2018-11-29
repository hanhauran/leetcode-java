package leetcode.code400;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2018/11/29 9:30
 */

public class Code383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = map(ransomNote);
        Map<Character, Integer> mMap = map(magazine);

        for (Map.Entry<Character, Integer> entry : rMap.entrySet()) {
            Character tmp = entry.getKey();
            if (mMap.getOrDefault(tmp, 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> map(String str) {
        Map<Character, Integer> map = new HashMap<>(26 * 4 / 3 + 1);
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            map.put(tmp, map.containsKey(tmp) ? map.get(tmp) + 1 : 1);
        }
        return map;
    }
}
