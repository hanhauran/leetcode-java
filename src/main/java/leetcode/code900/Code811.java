package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hr.han
 * @date 2019/1/2 15:16
 */

@Level(Levels.EASY)
public class Code811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] str = domain.split(" ");
            int times = Integer.parseInt(str[0]);
            map.put(str[1], map.containsKey(str[1]) ? map.get(str[1]) + times : times);

            for (int i = 0; i < str[1].length(); i++) {
                if (str[1].charAt(i) == '.') {
                    String cur = str[1].substring(i + 1);
                    map.put(cur, map.containsKey(cur) ? map.get(cur) + times : times);
                }
            }
        }

        List<String> result = new ArrayList<>(map.size() * 3 / 4 + 1);
//        map.forEach((k, v) -> result.add(v + " " + k));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
