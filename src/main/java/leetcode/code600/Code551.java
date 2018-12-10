package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/9 19:45
 */

public class Code551 {
    public boolean checkRecord(String s) {
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }
}
