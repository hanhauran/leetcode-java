package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/17 17:40
 */

@Level(Levels.HARD)
@Question("文本左右对齐")
public class Code68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int len = 0;

        for (String word : words) {
            if (tmp.isEmpty()) {
                tmp.add(word);
                len += word.length();
            } else {
                int after = len + word.length() + 1;
                if (after <= maxWidth) {
                    len = after;
                    tmp.add(word);
                } else {
                    helper(res, tmp, maxWidth, len);
                    tmp.clear();
                    tmp.add(word);
                    len = word.length();
                }
            }
        }

        if (! tmp.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (String word : tmp) {
                if (builder.length() == 0) {
                    builder.append(word);
                } else {
                    builder.append(' ').append(word);
                }
            }
            while (builder.length() != maxWidth) {
                builder.append(' ');
            }
            res.add(builder.toString());
        }

        return res;
    }

    private void helper(List<String> res, List<String> tmp, int maxWidth, int len) {
        if (tmp.size() == 1) {
            int spaces = maxWidth - len;
            StringBuilder builder = new StringBuilder();
            builder.append(tmp.get(0));
            while (spaces > 0) {
                builder.append(' ');
                spaces--;
            }
            res.add(builder.toString());
            return;
        }

        int divides = maxWidth - len;
        int each = divides / (tmp.size() - 1);
        int times = divides - each * (tmp.size() - 1);
        StringBuilder builder = new StringBuilder();
        for (String word : tmp) {
            if (builder.length() == 0) {
                builder.append(word);
            } else {
                int spaces;
                if (times-- > 0) {
                    spaces = 1 + each + 1;
                } else {
                    spaces = 1 + each;
                }
                while (spaces-- != 0) {
                    builder.append(' ');
                }
                builder.append(word);
            }
        }
        res.add(builder.toString());
    }

    public static void main(String[] args) {
        Code68 code = new Code68();
        System.out.println(code.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
        20));
    }
}
