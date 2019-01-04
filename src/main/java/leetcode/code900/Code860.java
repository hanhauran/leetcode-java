package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/3 9:38
 */

@Level(Levels.EASY)
public class Code860 {
    public boolean lemonadeChange(int[] bills) {
        int[] helper = new int[3];

        int way = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5: way = 0; break;
                case 10: way = 1; break;
                case 20: way = 2; break;
                default:
            }
            helper[way]++;

            if (way == 1) {
                if (helper[0] == 0) {
                    return false;
                } else {
                    helper[0]--;
                }
            } else if (way == 2) {
                if (helper[1] != 0 && helper[0] != 0) {
                    helper[1]--;
                    helper[0]--;
                } else if (helper[1] == 0 && helper[0] > 2) {
                    helper[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code860 code = new Code860();
        System.out.println(code.lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}));
    }
}
