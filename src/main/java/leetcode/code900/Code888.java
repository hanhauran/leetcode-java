package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/3 16:42
 */

@Level(Levels.EASY)
public class Code888 {
    public int[] fairCandySwap2(int[] a, int[] b) {
        int aSum = 0, bSum = 0;
        BitSet bitSet = new BitSet();
        for (int i : a) {
            bitSet.set(i, true);
            aSum += i;
        }
        for (int i : b) {
            bSum += i;
        }
        for (int i : b) {
            int j = (aSum - bSum + 2 * i) / 2;
            if (bitSet.get(j)) {
                return new int[]{j, i};
            }
        }
        return null;
    }

    public int[] fairCandySwap(int[] a, int[] b) {
        Set<Integer> bSet = new HashSet<>();
        int aSum = helper(a, null, false);
        int bSum = helper(b, bSet, true);

        for (int i : a) {
            int j = (bSum - aSum + 2 * i) / 2;
            if (j > 0 && bSet.contains(j)) {
                return new int[]{i, j};
            }
        }

        return null;
    }

    private int helper(int[] ints, Set<Integer> res, boolean useSet) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
            if (useSet) {
                res.add(i);
            }
        }
        return sum;
    }
}
