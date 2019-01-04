package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/4 20:36
 */

@Level(Levels.EASY)
public class Code905 {
    public int[] sortArrayByParity(int[] a) {
        int left = 0, right = a.length - 1;

        while (left < a.length && a[left] % 2 == 0) {
            left++;
        }

        while (right >= 0 && a[right] % 2 != 0) {
            right--;
        }

        while (left < right) {
            if (a[left] % 2 == 0) {
                left++;
            } else if (a[right] % 2 != 0) {
                right--;
            } else {
                int tmp = a[left];
                a[left++] = a[right];
                a[right--] = tmp;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Code905 code = new Code905();
        System.out.println(Arrays.toString(code.sortArrayByParity(new int[]{1, 3, 0, 5, 2})));
    }
}
