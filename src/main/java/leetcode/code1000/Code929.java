package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/5 12:36
 */

@Level(Levels.EASY)
public class Code929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String email : emails) {
            helper(email, res);
        }
        return res.size();
    }

    private void helper(String email, Set<String> res) {
        String[] parts = email.split("@");
        StringBuilder builder = new StringBuilder();

        char[] chars = parts[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                break;
            } else if (chars[i] != '.'){
                builder.append(chars[i]);
            }
        }

        res.add(builder.append("@").append(parts[1]).toString());
    }
}
