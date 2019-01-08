package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

/**
 * @author hr.han
 * @date 2019/1/8 12:55
 */

@Level(Levels.MEDIUM)
@Question("字符串相乘")
public class Code43 {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        int[] res = new int[num1.length() + num2.length()];

        for (int i = cs1.length - 1; i >= 0; i--) {
            for (int j = cs2.length - 1; j >= 0; j--) {
                int val = (cs1[i] - '0') * (cs2[j] - '0');
                res[i + j + 1] += val;
                if (res[i + j + 1] >= 10) {
                    res[i + j] += res[i + j + 1] / 10;
                    res[i + j + 1] %= 10;
                }
//                val += res[i + j + 1];
//                res[i + j + 1] = val % 10;
//                res[i + j] += val / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i : res) {
            if (builder.length() == 0 && i == 0) {
                continue;
            }
            builder.append(i);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
