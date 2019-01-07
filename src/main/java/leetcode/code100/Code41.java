package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.Arrays;
import java.util.BitSet;
import java.util.TreeSet;

/**
 * @author hr.han
 * @date 2019/1/7 19:34
 */

@Level(Levels.HARD)
public class Code41 {
    public int firstMissingPositive(int[] nums) {
        BitSet bs = new BitSet();
        for (int i : nums) {
            if (i > 0) {
                bs.set(i, true);
            }
        }

        if (bs.isEmpty()) {
            return 1;
        }

        int res = 1;
        while (true) {
            if (! bs.get(res)) {
                return res;
            } else {
                res++;
            }
        }

//        TreeSet<Integer> set = new TreeSet<>();
//        Arrays.stream(nums).forEach(item -> {
//            if (item > 0) {
//                set.add(item);
//            }
//        });
//
//        if (set.isEmpty()) {
//            return 1;
//        }
//
//        if (set.first() > 1) {
//            return 1;
//        } else {
//            int last = 0;
//            for (int i : set) {
//                if (i - last != 1) {
//                    return last + 1;
//                } else {
//                    last = i;
//                }
//            }
//            return last + 1;
//        }
    }
}
