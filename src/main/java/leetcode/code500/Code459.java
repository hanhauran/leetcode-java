package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 9:14
 */

public class Code459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        int j = 0;
        char[] chars = s.toCharArray();
        boolean flag = helper(chars, j);
        while (! flag) {
            j++;
            if (j >= chars.length / 2) {
                return false;
            }
            flag = helper(chars, j);
        }
        return true;
    }

    private boolean helper(char[] chars, int index) {
        for (int i = index + 1; i < chars.length; ) {
            if (i + index >= chars.length) {
                return false;
            }

            for (int j = 0; j <= index; j++) {
                if (chars[i++] != chars[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code459 code = new Code459();
        System.out.println(code.repeatedSubstringPattern("aba"));
    }
}
