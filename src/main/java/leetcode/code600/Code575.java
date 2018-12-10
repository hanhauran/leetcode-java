package leetcode.code600;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/10 15:30
 */

public class Code575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(candies).forEach(set::add);

        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }
}
