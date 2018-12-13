package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/12 20:50
 */

public class Code680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                break;
            }
            i++;
            j--;
        }

        if (i >= j) {
            return true;
        }

        return part(chars, i, j);
    }

    private boolean part(char[] chars, int left, int right) {
        // chars[left] != chars[right]
        // 1
        boolean flag1 = true;
        int i = left + 1, j = right;
        while (i < j) {
            if (chars[i] != chars[j]) {
                flag1 = false;
                break;
            }
            i++;
            j--;
        }

        if (flag1) {
            return true;
        }

        flag1 = true;
        i = left;
        j = right - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                flag1 = false;
                break;
            }
            i++;
            j--;
        }

        return flag1;
    }

    public static void main(String[] args) {
        Code680 code = new Code680();
        System.out.println(code.validPalindrome("cbbcc"));
    }
}
