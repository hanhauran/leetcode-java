package leetcode.code300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code205 {
    public boolean isIsomorphic(String s, String t) {
        return res(s, t) && res(t, s);
    }

    private boolean res(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (! map.containsKey(c)) {
                map.put(c, t.charAt(i));
            } else if (t.charAt(i) != map.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code205 code = new Code205();
        System.out.println(code.isIsomorphic("ab", "aa"));
    }
}
