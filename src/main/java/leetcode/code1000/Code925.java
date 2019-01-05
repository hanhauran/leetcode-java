package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 12:17
 */

@Level(Levels.EASY)
public class Code925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || name.isEmpty() || typed.isEmpty()) {
            return false;
        }

        char[] names = name.toCharArray();
        char[] types = typed.toCharArray();

        int i = 0, j = 0;
        char c1 = names[0], c2 = types[0];
        int s1 = 0, s2 = 0;

        while (true) {
            while (i < names.length && names[i] == c1) {
                i++;
                s1++;
            }

            while (j < types.length && types[j] == c2) {
                j++;
                s2++;
            }

            if (c1 != c2 || s1 > s2) {
                return false;
            }

            if (i < names.length) {
                c1 = names[i];
                s1 = 0;
            } else {
                break;
            }

            if (j < types.length) {
                c2 = types[j];
                s2 = 0;
            } else {
                break;
            }
        }

        return i == names.length && j == types.length;
    }

    public static void main(String[] args) {
        Code925 code = new Code925();
        System.out.println(code.isLongPressedName("laiden", "laiden"));
    }
}
