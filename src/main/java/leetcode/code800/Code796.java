package leetcode.code800;

/**
 * @author hr.han
 * @date 2019/1/2 14:36
 */

public class Code796 {
    public boolean rotateString2(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        return (a + a).contains(b);
    }

    public boolean rotateString(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        if (a.length() == 0) {
            return true;
        }

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(0)) {
                String rev = b.substring(i) + b.substring(0, i);
                if (a.equals(rev)) {
                    return true;
                }
            }
        }

        return false;
    }
}
