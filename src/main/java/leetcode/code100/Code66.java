package leetcode.code100;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code66 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            return new int[]{digits[0] + 1};
        }

        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < digits.length; i++) {
            sum = sum.multiply(BigInteger.valueOf(10L));
            sum = sum.add(BigInteger.valueOf(digits[i]));
        }

        sum = sum.add(BigInteger.valueOf(1L));
        char[] chars = sum.toString().toCharArray();
        int[] array = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            array[i] = Integer.valueOf(String.valueOf(chars[i]));
        }
        return array;
    }

    public int[] plusOne2(int[] digits) {
        int[] result = new int[digits.length];
        int cur = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            int tmp = digits[i] + cur;
            if (tmp >= 10) {
                result[i] = tmp - 10;
                cur = 1;
            } else {
                result[i] = tmp;
                cur = 0;
            }
        }
        if (cur == 0) {
            return result;
        } else {
            int[] array = new int[result.length + 1];
            array[0] = 1;
            // useless
            System.arraycopy(result, 0, array, 1, result.length);
            return array;
        }
    }

    public static void main(String[] args) {
        Code66 code = new Code66();
        System.out.println(Arrays.toString(code.plusOne2(new int[]{9,9,9})));
    }
}
