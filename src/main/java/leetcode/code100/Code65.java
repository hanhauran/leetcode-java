package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/17 17:07
 */

@Level(Levels.HARD)
@Question("验证给定的字符串是否为数字。")
@Unsolved
@Fucked("出题人脑子有问题")
public class Code65 {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int hasPoint = -1;
        int hasE = -1;
        int hasSpace = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isSpaceChar(c)) {
                return false;
            } else if (Character.isLetter(c)) {
                if (c == 'e' || c == 'E') {
                    if (hasE == -1) {
                        hasE = i;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (hasPoint == -1) {
                    hasPoint = i;
                } else {
                    return false;
                }
            }
        }

        if (hasE != -1) {
            return hasE != 0 && hasE != chars.length - 1 && (hasPoint == -1 || hasPoint < hasE);
        }

        if (hasPoint != -1) {
            return chars.length != 1;
        }

        return true;
    }
}
