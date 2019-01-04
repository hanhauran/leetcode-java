package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 15:00
 */

@Level(Levels.EASY)
public class Code806 {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int index = 0;
        int count = 0;
        int cur = 0;
        while (index != s.length()) {
            int width = widths[chars[index] - 'a'];
//            if (cur + width <= 100) {
//                cur += width;
//                index++;
//                continue;
//            }
//
//            count++;
//            cur = width;
//            index++;

            cur += width;
            if (cur > 100) {
                count++;
                cur = width;
            }
            index++;
        }

        return new int[]{++count, cur};
    }
}
