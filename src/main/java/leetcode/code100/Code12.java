package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

/**
 * @author hr.han
 * @date 2019/1/5 17:27
 */

@Level(Levels.MEDIUM)
@Question("num -> 罗马数字")
public class Code12 {
    public String intToRoman(int nums) {
        int[] trans = transfer(nums);
        return toRoman(trans);
    }

    private static final int[] BITS = {1000, 500, 100, 50, 10, 5, 1};
    private static final char[] CHARS = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    private String toRoman(int[] trans) {
        StringBuilder builder = new StringBuilder();
        build(trans[0], builder, CHARS[0]);
        toRomanPart(trans, builder, 1);
        toRomanPart(trans, builder, 3);
        toRomanPart(trans, builder, 5);
        return builder.toString();
    }

    private void toRomanPart(int[] trans, StringBuilder builder, int start) {
        if (trans[start] == 0) {
            if (trans[start + 1] < 4) {
                build(trans[start + 1], builder, CHARS[start + 1]);
            } else {
                builder.append(CHARS[start + 1]).append(CHARS[start]);
            }
        } else {
            if (trans[start + 1] < 4) {
                build(trans[start], builder, CHARS[start]);
                build(trans[start + 1], builder, CHARS[start + 1]);
            } else {
                builder.append(CHARS[start + 1]).append(CHARS[start - 1]);
            }
        }
    }

    private void build(int count, StringBuilder builder, char c) {
        while (count != 0) {
            builder.append(c);
            count--;
        }
    }

    private int[] transfer(int num) {
        int[] res = new int[7];
        int offset = 0;

        while (num != 0) {
            res[offset] = num / BITS[offset];
            num %= BITS[offset];
            offset++;
        }
        return res;
    }

    public static void main(String[] args) {
        Code12 code = new Code12();
        System.out.println(code.intToRoman(1994));
    }
}
