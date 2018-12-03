package leetcode.code500;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/3 14:29
 */

public class Code492 {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int tmp = (int) Math.sqrt(area);
        while (true) {
            if (area % tmp == 0) {
                result[0] = area / tmp;
                result[1] = tmp;
                return result;
            } else {
                tmp--;
            }
        }
    }

    public static void main(String[] args) {
        Code492 code = new Code492();
        System.out.println(Arrays.toString(code.constructRectangle(4)));
    }
}
