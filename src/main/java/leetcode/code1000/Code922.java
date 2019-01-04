package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/4 21:20
 */

@Level(Levels.EASY)
public class Code922 {
    public int[] sortArrayByParityII(int[] a) {
        int odd = 1, even = 0;

        while (true) {
            odd = finder(a, odd, false);
            even = finder(a, even, true);

            if (odd == -1 || even == -1) {
                break;
            }

            int tmp = a[odd];
            a[odd] = a[even];
            a[even] = tmp;
        }

        return a;
    }

    private int finder(int[] arr, int start, boolean even) {
        while (start < arr.length) {
            if (even) {
                if (arr[start] % 2 != 0) {
                    return start;
                } else {
                    start += 2;
                }
            } else {
                if (arr[start] % 2 == 0) {
                    return start;
                } else {
                    start += 2;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Code922 code = new Code922();
        System.out.println(Arrays.toString(code.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
