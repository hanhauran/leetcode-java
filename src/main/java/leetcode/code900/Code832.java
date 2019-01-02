package leetcode.code900;

import annotation.Level;
import annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 20:00
 */

@Level(Levels.EASY)
public class Code832 {
    public int[][] flipAndInvertImage(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            helper(a[i]);
        }
        return a;
    }

    private void helper(int[] line) {
        int left = 0, right = line.length - 1;
        while (left <= right) {
            int tmp = line[left] ^ 1;
            line[left++] = line[right] ^ 1;
            line[right--] = tmp;
        }
    }
}
