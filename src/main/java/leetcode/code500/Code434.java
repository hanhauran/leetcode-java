package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/11/30 20:47
 */

public class Code434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                count++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Code434 code = new Code434();
        System.out.println(code.countSegments("  B C D"));
    }
}
