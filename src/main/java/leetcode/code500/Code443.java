package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/1 16:20
 */

public class Code443 {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                if (count == 1) {
                    sb.append(cur);
                } else {
                    sb.append(cur).append(count);
                }
                cur = chars[i];
                count = 1;
            }
        }

        if (count == 1) {
            sb.append(cur);
        } else {
            sb.append(cur).append(count);
        }

        for (int i = 0; i < sb.toString().toCharArray().length; i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

    public static void main(String[] args) {
        Code443 code = new Code443();
        System.out.println(code.compress("aabbccc".toCharArray()));
    }
}
