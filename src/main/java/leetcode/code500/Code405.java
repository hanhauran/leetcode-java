package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/11/30 15:28
 */

public class Code405 {
    private static final char[] DIGITS = "0123456789abcdef".toCharArray();

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num & 1);
            num >>>= 1;
        }

        while (sb.length() % 4 != 0) {
            sb.append(0);
        }
        return toHexPart(sb.reverse().toString());
    }

    public String toHexPart(String binary) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 4) {
            sb.append(part(i, i + 4, binary));
        }
        return sb.toString();
    }

    public char part(int left, int right, String binary) {
        int res = 0;
        for (int i = left; i < right; i++) {
            if (binary.charAt(i) == '1') {
                res <<= 1;
                res ++;
            } else {
                res <<= 1;
            }
        }
        return DIGITS[res];
    }

    public static void main(String[] args) {
        Code405 code = new Code405();
        System.out.println(code.toHex(12));
    }

}
