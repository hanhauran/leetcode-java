package leetcode.code400;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hr.han
 * @date 2018/11/29 9:38
 */

public class Code387 {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            map.put(tmp, map.containsKey(tmp) ? map.get(tmp) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }

    public int firstUniqChar3(String s) {
        for(char c:s.toCharArray()) {
            int index = s.indexOf(c);
            if(index==s.lastIndexOf(c)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code387 code = new Code387();
        System.out.println(code.firstUniqChar3("cc"));
    }
}
