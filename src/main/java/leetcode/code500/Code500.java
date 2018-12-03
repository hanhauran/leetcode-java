package leetcode.code500;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/3 14:48
 */

public class Code500 {
    private static final Map<Character, Integer> MAP = new HashMap<>(26 * 4 / 3 + 1);
    static {
        for (char c : "QWERTYUIOPqwertyuiop".toCharArray()) {
            MAP.put(c, 1);
        }
        for (char c : "ASDFGHJKLasdfghjkl".toCharArray()) {
            MAP.put(c, 2);
        }
        for (char c : "ZXCVBNMzxcvbnm".toCharArray()) {
            MAP.put(c, 3);
        }
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (check(word)) {
                result.add(word);
            }
        }
        String[] res = new String[result.size()];
        result.toArray(res);
        return res;
    }

    private boolean check(String word) {
        Integer tmp = null;
        for (char c : word.toCharArray()) {
            if (tmp == null) {
                tmp = MAP.get(c);
            } else {
                if (! tmp.equals(MAP.get(c))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code500 code = new Code500();
        System.out.println(Arrays.toString(code.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
