package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 13:48
 */

public class Code482 {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        char[] chars = s.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();

        int count = k;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }

            count--;
            sb.append(chars[i]);
            if (count == 0) {
                count = k;
                sb.append('-');
            }
        }

        if (sb.length() == 0) {
            return "";
        }

        return sb.charAt(sb.length() - 1) == '-' ? sb.reverse().substring(1) : sb.reverse().toString();
    }

    public static void main(String[] args) {
        Code482 code = new Code482();
        System.out.println(code.licenseKeyFormatting("---", 3));
    }
}
