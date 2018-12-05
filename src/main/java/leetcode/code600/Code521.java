package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/5 20:34
 */

public class Code521 {
    public int findLUSlength(String a, String b) {
        return a.length() == b.length() ? (a.equals(b) ? -1 : a.length()) : Math.max(a.length(), b.length());
    }
}
