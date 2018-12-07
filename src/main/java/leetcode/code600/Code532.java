package leetcode.code600;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/6 17:18
 */

public class Code532 {
    public int findPairs(int[] nums, int k) {
        if (k == 0) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.stream(nums).forEach(item -> map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue() >= 2 ? 1 : 0;
            }
            return count;
        }

        if (k < 0) {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(nums).forEach(set::add);

        int count = 0;
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int cur = iter.next();
            if (set.contains(cur + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Code532 code = new Code532();
        System.out.println(code.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
    }
}
