package leetcode.code500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/11/30 15:56
 */

public class Code412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
