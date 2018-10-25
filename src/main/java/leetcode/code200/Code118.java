package leetcode.code200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/10/25
 */

public class Code118 {

    private static final List<List<Integer>> cache = new ArrayList<>();
    static {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        cache.add(list);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        if (numRows > cache.size()) {
            for (int index = cache.size(); index < numRows; index++) {
                List<Integer> list = part(cache.get(index - 1));
                cache.add(list);
            }
        }

        for (int i = 0; i < numRows; i++) {
            result.add(cache.get(i));
        }
        return result;
    }

    private List<Integer> part(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            result.add(list.get(i) + list.get(i + 1));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        Code118 code = new Code118();
        System.out.println(code.generate(5));
    }
}
