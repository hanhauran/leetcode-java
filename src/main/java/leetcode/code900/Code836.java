package leetcode.code900;

import finder.annotation.Interesting;
import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/2 20:06
 */

@Level(Levels.EASY)
@Interesting("给出两个矩形，判断它们是否重叠并返回结果。")
public class Code836 {
    /**
     * q
     * @param rec1 (x1, y1, x2, y2)
     * @param rec2 (x1, y1, x2, y2)
     * @return bool
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])
                && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }
}
