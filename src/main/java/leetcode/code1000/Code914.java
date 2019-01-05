package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2019/1/4 21:06
 */

@Level(Levels.EASY)
public class Code914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
//        Arrays.stream(deck).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1));
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer x = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (x == null) {
                x = entry.getValue();
            } else {
                if (x > entry.getValue()) {
                    x = helper(x, entry.getValue());
                } else {
                    x = helper(entry.getValue(), x);
                }
            }

            if (x == 1) {
                return false;
            }
        }
        return true;
    }

    private int helper(int max, int min) {
        return max % min == 0 ? min : helper(min, max % min);
    }
}
