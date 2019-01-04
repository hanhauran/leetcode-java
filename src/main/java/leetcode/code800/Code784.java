package leetcode.code800;

import finder.annotation.Interesting;
import finder.annotation.Unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/2 13:31
 */

@Unsolved
@Interesting("给定一个字符串S，通过将字符串S中的每个字母转变大小写，" +
        "我们可以获得一个新的字符串。返回所有可能得到的字符串集合。")
public class Code784 {
    public List<String> letterCasePermutation(String s) {
        if (s == null) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        helper(s.toLowerCase().toCharArray(), 0, result, new StringBuilder());
        return result;
    }

    private void helper(char[] s, int index, List<String> result, StringBuilder builder) {
        if (index == s.length) {
            result.add(builder.toString());
            return;
        }

        char c = s[index];
        if (c >= 'a' && c <= 'z') {
            builder.append(c);
            helper(s, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);

            builder.append(Character.toUpperCase(c));
            helper(s, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(c);
            helper(s, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
