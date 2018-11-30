package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/11/30 19:37
 */

public class Code415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            StringBuilder sb = new StringBuilder(num1);
            while (sb.length() != num2.length()) {
                sb.insert(0, 0);
            }
            num1 = sb.toString();
        } else if (num1.length() > num2.length()) {
            StringBuilder sb = new StringBuilder(num2);
            while (sb.length() != num1.length()) {
                sb.insert(0, 0);
            }
            num2 = sb.toString();
        }

        return part(num1, num2);
    }

    private String part(String left, String right) {
        if (left.length() != right.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = left.length() - 1; i >= 0; i--) {
            int lNum = Integer.parseInt(String.valueOf(left.charAt(i)));
            int rNum = Integer.parseInt(String.valueOf(right.charAt(i)));
            int tmp = lNum + rNum;
            if (flag) {
                tmp++;
            }
            if (tmp >= 10) {
                tmp -= 10;
                flag = true;
            } else {
                flag = false;
            }
            sb.append(tmp);
        }
        if (flag) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Code415 code = new Code415();
        System.out.println(code.addStrings("999", "12345"));
    }
}
