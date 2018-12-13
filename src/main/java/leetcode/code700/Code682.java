package leetcode.code700;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/12 20:59
 */

public class Code682 {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            switch (op) {
                case "+": {
                    int size = list.size();
                    list.add(list.get(size - 1) + list.get(size - 2));
                    break;
                }
                case "D": {
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                }
                case "C": {
                    list.remove(list.size() - 1);
                    break;
                }
                default: {
                    list.add(Integer.parseInt(op));
                    break;
                }
            }
        }

        int count = 0;
        for (int i : list) {
            count += i;
        }
        return count;
    }
}
