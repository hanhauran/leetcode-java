package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code67 {
    public String addBinary(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }

        char[] left = a.toCharArray();
        char[] right = b.toCharArray();
        StringBuilder builder = new StringBuilder();

        int l = left.length - 1;
        int r = right.length - 1;
        int tmp = 0;

        while (true) {
            if (l < 0) {
                while (r >= 0) {
                    int cur = Integer.valueOf(String.valueOf(right[r])) + tmp;
                    if (cur < 2) {
                        builder.append(cur);
                        tmp = 0;
                    } else {
                        builder.append(cur % 2);
                        tmp = 1;
                    }
                    r--;
                }
                break;
            }

            if (r < 0) {
                while (l >= 0) {
                    int cur = Integer.valueOf(String.valueOf(left[l])) + tmp;
                    if (cur < 2) {
                        builder.append(cur);
                        tmp = 0;
                    } else {
                        builder.append(cur % 2);
                        tmp = 1;
                    }
                    l--;
                }
                break;
            }

            int cur = Integer.valueOf(String.valueOf(left[l])) + Integer.valueOf(String.valueOf(right[r])) + tmp;
            if (cur == 0 || cur == 1) {
                builder.append(cur);
                tmp = 0;
            } else {
                tmp = 1;
                builder.append(cur % 2);
            }
            l--;
            r--;
        }

        if (tmp == 1) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Code67 code = new Code67();
        System.out.println(code.addBinary("101", "1011"));
    }
}
