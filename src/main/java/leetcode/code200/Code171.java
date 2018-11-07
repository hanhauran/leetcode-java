package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code171 {
    public int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cur = ((int) chars[i]) - 64;
            result += (int) (cur * Math.pow(26, chars.length - 1 - i));
        }
        return result;
    }

    public static void main(String[] args) {
        Code171 code = new Code171();
        System.out.println(code.titleToNumber("ZY"));
    }
}
