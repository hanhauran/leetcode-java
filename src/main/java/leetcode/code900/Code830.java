package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/2 19:51
 */

@Level(Levels.EASY)
public class Code830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        char tmp = ' ';
        int count = 1;
        int startOffset = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != tmp) {
                if (count >= 3) {
                    List<Integer> item = new ArrayList<>(4);
                    item.add(startOffset);
                    item.add(i - 1);
                    result.add(item);
                }

                tmp = c;
                startOffset = i;
                count = 1;
            } else {
                count++;
            }
        }

        if (count >= 3) {
            List<Integer> item = new ArrayList<>();
            item.add(startOffset);
            item.add(s.length() - 1);
            result.add(item);
        }

        return result;
    }

    public static void main(String[] args) {
        Code830 code = new Code830();
        System.out.println(code.largeGroupPositions("abbxxxxzzy"));
    }
}
