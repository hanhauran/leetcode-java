package leetcode.code800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/22 12:40
 */

public class Code728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (validate(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean validate(int num) {
        if (num == 0) {
            return false;
        }

        int cur = num;
        while (cur != 0) {
            int left = cur % 10;
            if (left == 0) {
                return false;
            }
            if (num % left == 0) {
                cur = cur / 10;
            } else {
                return false;
            }
        }
        return true;
    }
}
