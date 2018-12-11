package leetcode.code600;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/11 14:21
 */

public class Code599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int sum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int cur = map.get(list2[i]) + i;
                if (cur < sum) {
                    res.clear();
                    sum = cur;
                    res.add(list2[i]);
                } else if (cur == sum) {
                    res.add(list2[i]);
                }
            }
        }

        String[] resa = new String[res.size()];
        res.toArray(resa);

        return resa;
    }
}
