package leetcode.code100;

import finder.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/6 20:41
 */

@Level(Levels.MEDIUM)
@Method(Methods.BFS)
@Question("给出 n 代表生成括号的对数，生成所有可能的并且有效的括号组合。")
public class Code22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        generate(new StringBuilder(), res, 0, 0, n);
        return res;
    }

    private void generate(StringBuilder builder, List<String> res, int left, int right, int n) {
        if (left > n || right > n || left < right) {
            return;
        }

        if (left == n && right == n) {
            res.add(builder.toString());
            return;
        }

        generate(builder.append('('), res, left + 1, right, n);
        builder.deleteCharAt(builder.length() - 1);
        generate(builder.append(')'), res, left, right + 1, n);
        builder.deleteCharAt(builder.length() - 1);
    }

    public static void main(String[] args) {
        Code22 code = new Code22();
        System.out.println(code.generateParenthesis(3));
    }
}
