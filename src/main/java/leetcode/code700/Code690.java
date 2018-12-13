package leetcode.code700;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/13 11:24
 */

public class Code690 {

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private int res = 0;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(employees.size() * 3 / 4 + 1);
        employees.forEach(employee -> map.put(employee.id, employee));
        helper(map, id);
        return res;
    }

    private void helper(Map<Integer, Employee> map, int id) {
        Employee cur = map.get(id);
        res += cur.importance;
        for (int i : cur.subordinates) {
            helper(map, i);
        }
//        cur.subordinates.forEach(e -> {
//            helper(map, e);
//        });
    }
}
