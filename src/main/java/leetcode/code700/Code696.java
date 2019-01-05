package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/13 11:41
 */

public class Code696 {
    public int countBinarySubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] helper = new int[chars.length];
        int offset = 0;
        helper[offset] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                helper[++offset]++;
            } else {
                helper[offset]++;
            }
        }

        int res = 0;
        for (int i = 1; i <= offset; i++) {
            res += Math.min(helper[i - 1], helper[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Code696 code = new Code696();
        System.out.println(code.countBinarySubstrings("10101"));
    }
}
