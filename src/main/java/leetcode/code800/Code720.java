package leetcode.code800;

import annotation.Interesting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/14 16:15
 */

@Interesting("给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。")
public class Code720 {
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return null;
        }

        if (words.length == 1) {
            return words[0].length() == 1 ? words[0] : null;
        }

        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";

        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Code720 code = new Code720();
        System.out.println(code.longestWord(new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
    }
}
