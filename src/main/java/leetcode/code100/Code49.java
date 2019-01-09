package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/8 20:57
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。",
        input = "[eat, tea, tan, ate, nat, bat]",
        output = "[ [eat, tea, ate], [nat, tan], [bat] ]"
)
public class Code49 {
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (! res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // fuck, today is done.
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            String tmp = buildUniqueString(str);
            if (! res.containsKey(tmp)) {
                res.put(tmp, new ArrayList<>());
            }
            res.get(tmp).add(str);
        }

        return new ArrayList<>(res.values());
    }

    private String buildUniqueString(String str) {
        char[] chars = str.toCharArray();
        int[] helper = new int[26];
        for (char c : chars) {
            helper[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i : helper) {
            String tmp = String.format("%032d", i);
            builder.append(tmp);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Code49 code = new Code49();
        System.out.println(code.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(code.buildUniqueString("eat"));
    }
}
