package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/12 21:05
 */

public class Code686 {
    public int repeatedStringMatch(String a, String b) {
        if (a.length() >= b.length()) {
            return a.contains(b) ? 1 : ((a + a).contains(b) ? 2 : -1);
        }

        StringBuilder builder = new StringBuilder();
        int count = b.length() / a.length();
        for (int i = 0; i < count; i++) {
            builder.append(a);
        }

        if (builder.toString().contains(b)) {
            return count;
        }

        builder.append(a);
        count++;
        if (builder.toString().contains(b)) {
            return count;
        }

        builder.append(a);
        count++;
        if (builder.toString().contains(b)) {
            return count;
        }

        return -1;
    }

    public static void main(String[] args) {
        Code686 code = new Code686();
        System.out.println(code.repeatedStringMatch("aa", "a"));
    }
}
