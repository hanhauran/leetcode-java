package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/10/26
 */

public class Code125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (! Character.isLetterOrDigit(chars[i])) {
                i++;
            } else if (! Character.isLetterOrDigit(chars[j])) {
                j--;
            } else {
                if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code125 code = new Code125();
        System.out.println(code.isPalindrome(".,"));
    }
}
