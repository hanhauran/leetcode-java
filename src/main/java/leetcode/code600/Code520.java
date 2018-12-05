package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/5 20:25
 */

public class Code520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }

        char[] chars = word.toCharArray();
        boolean upperOf0 = Character.isUpperCase(chars[0]);
        boolean upperOf1 = Character.isUpperCase(chars[1]);
        if (upperOf0 && upperOf1) {
            return part(chars, 2, 1);
        }

        if (! upperOf1) {
            return part(chars, 2, 2);
        }

        return false;
    }

    private boolean part(char[] chars, int offset, int style) {
        // style == 1 means like this: US.
        // style == 2 means like this: us. / Us.
        if (style == 1) {
            for (int i = offset; i < chars.length; i++) {
                if (Character.isLowerCase(chars[i])) {
                    return false;
                }
            }
            return true;
        } else if (style == 2) {
            for (int i = offset; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Code520 code = new Code520();
        System.out.println(code.detectCapitalUse("leetCode"));
    }
}
