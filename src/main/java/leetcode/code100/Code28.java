package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty()) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";
        Code28 code = new Code28();
        System.out.println(code.strStr(a, b));
    }
}
