package leetcode.code500;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/3 8:32
 */

public class Code455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1, j = s.length - 1;
        int res = 0;

        while (i >= 0 && j >= 0) {
            if (g[i] > s[j]) {
                i--;
            } else {
                i--;
                j--;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Code455 code = new Code455();
        System.out.println(code.findContentChildren(new int[]{1, 2}, new int[]{1, 1, 3}));
    }
}
