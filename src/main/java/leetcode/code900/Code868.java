package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/3 9:51
 */

@Level(Levels.EASY)
public class Code868 {
    public int binaryGap(int n) {
        if (n == 0) {
            return 0;
        }

        int count = 0;
        int max = count;
        int tmp = n & 1;
        while (tmp == 0) {
            n = n >>> 1;
            tmp = n & 1;
        }

        while (n != 0) {
            tmp = n & 1;
            if (tmp == 1) {
                if (count == 0) {
                    count++;
                } else {
                    if (max < count) {
                        max = count;
                    }
                    count = 1;
                }
            } else {
                count++;
            }
            n = n >>> 1;
        }

        return max;
    }

    public static void main(String[] args) {
        Code868 code = new Code868();
        System.out.println(code.binaryGap(22));
        System.out.println(Integer.toBinaryString(22));
    }
}
