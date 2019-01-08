package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Collections;
import java.util.List;

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
    public List<List<String>> groupAnagrams(String[] strs) {
        // fuck, today is done.
        return Collections.emptyList();
    }
    
    public static void main(String[] args) {
        Code49 code = new Code49();
        System.out.println(code.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
