package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/6 20:17
 */

public class Code541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, i + k - 1);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            right = chars.length - 1;
        }

        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Code541 code = new Code541();
        System.out.println(code.reverseStr("abcdefg", 2));
    }
}
