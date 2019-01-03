package leetcode.code900;

import annotation.Level;
import annotation.Levels;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/3 10:13
 */

@Level(Levels.EASY)
public class Code874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] xg = {0, -1, 0, 1};
        int[] yg = {1, 0, -1, 0};

        Set<Long> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(((long) obstacle[0] + 30000) << 16 | ((long) obstacle[1] + 30000));
        }

        int max = 0;
        int direction = 0;
        int cx, cy;
        int x = 0;
        int y = 0;
        for (int command : commands) {
            switch (command) {
                case -1: direction = (direction + 3) % 4; break;
                case -2: direction = (direction + 1) % 4; break;
                default:
                    for (int i = 0; i < command; i++) {
                        cx = x + xg[direction];
                        cy = y + yg[direction];
                        if (! set.contains(((long) cx + 30000) << 16 | ((long) cy + 30000))) {
                            x = cx;
                            y = cy;
                            max = Math.max(max, x * x + y * y);
                        }
                    }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Code874 code = new Code874();
        System.out.println(code.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{
                {2,4}
        }));
    }
}
