package leetcode.code200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/10/25
 */

public class Code119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 0; i < rowIndex; i++) {
            generate(result);
        }

        return result;
    }

    private void generate(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
        list.remove(list.size() - 1);
        list.add(0, 1);
        list.add(1);
    }

    public static void main(String[] args) {
        Code119 code = new Code119();
        System.out.println(code.getRow(0));
    }
}
