package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/7 8:58
 */

@Level(Levels.HARD)
@Question("在 s 中找出可以恰好串联 words 中所有单词(长度相同，可能重复)的子串的起始位置")
public class Code30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> kv = new HashMap<>(words.length * 4 / 3 + 1);
        int[] mark = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (! kv.containsKey(words[i])) {
                kv.put(words[i], i);
            }
            mark[kv.get(words[i])]++;
        }

        int itemLen = words[0].length();
        List<Integer> vList = new ArrayList<>();
        for (int i = 0; i <= s.length() - itemLen; i++) {
            String key = s.substring(i, i + itemLen);
            boolean flag = kv.containsKey(key);
            if (flag) {
                vList.add(kv.get(key));
            } else {
                vList.add(-1);
            }
        }

        return getResult(s.length(), words.length, words[0].length(), vList, mark);
    }

    private List<Integer> getResult(int sLen, int n, int itemLen, List<Integer> vList, final int[] mark) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= sLen - n * itemLen; i++) {
            if (check(n, itemLen, vList, i, mark)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean check(int n, int itemLen, List<Integer> vList, int offset, final int[] mark) {
        int[] helper = new int[n + 1];
        int index = 0;
        while (index < n) {
            int off = index * itemLen + offset;
            if (vList.get(off) == -1) {
                helper[n]++;
                return false;
            } else {
                helper[vList.get(off)]++;
            }
            index++;
        }

        return validate(helper, mark);
    }

    private boolean validate(final int[] helper, final int[] mark) {
        if (helper[helper.length - 1] != 0) {
            return false;
        }

        for (int i = 0; i < helper.length - 1; i++) {
            if (helper[i] != mark[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code30 code = new Code30();
        System.out.println(code.findSubstring("aaaaaaaa", new String[]{"aa","aa","aa",}));
    }
}
