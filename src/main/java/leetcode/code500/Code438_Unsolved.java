package leetcode.code500;

import annotation.Unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/1 15:13
 */

@Unsolved
public class Code438_Unsolved {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return Collections.emptyList();
        }

        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (--chars[s.charAt(right++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if (right - left == p.length() && chars[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Code438_Unsolved code = new Code438_Unsolved();
        System.out.println(code.findAnagrams("dabcdabc", "abc"));
    }
}
