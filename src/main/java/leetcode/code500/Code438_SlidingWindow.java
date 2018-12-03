package leetcode.code500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/2 14:36
 */

public class Code438_SlidingWindow {
    public List<Integer> findAnagrams(String target, String fragment) {
        if (target == null || target.length() == 0 || fragment == null || fragment.length() == 0) {
            return Collections.emptyList();
        }

        int[] helper = new int[26];
        for (char c : fragment.toCharArray()) {
            helper[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        int count = fragment.length();
        while (right < target.length()) {
            if (--helper[target.charAt(right++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) {
                result.add(left);
            }
            if (right - left == fragment.length() && helper[target.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Code438_SlidingWindow code = new Code438_SlidingWindow();
        System.out.println(code.findAnagrams("abcdabc", "bca"));
    }
}
