package algorithms;

import java.util.*;

/**
 * @author hr.han
 * @date 2019/1/8 16:47
 */

public class FullyArranger {
    /**
     * 全排列
     * @param items 不包含重复元素数组
     * @return 所有排序结果
     */
    public static List<List<Integer>> arrange(int[] items) {
        return arrange(items, false);
    }

    public static List<List<Integer>> arrange(int[] items, boolean hasRepeatingElements) {
        if (items == null || items.length == 0) {
            return Collections.emptyList();
        }

        if (hasRepeatingElements) {
            Arrays.sort(items);
        }

        List<List<Integer>> res = new ArrayList<>();
        recurse(items, 0, res, hasRepeatingElements);
        return res;
    }

    private static void recurse(int[] items, int offset, List<List<Integer>> res, boolean hasRepeatingElements) {
        if (offset == items.length) {
            add(items, res);
            return;
        }

        Set<Integer> set = null;
        if (hasRepeatingElements) {
            set = new HashSet<>();
        }

        for (int i = offset; i < items.length; i++) {
            if (hasRepeatingElements) {
                if (set.contains(items[i])) {
                    continue;
                }
                set.add(items[i]);
            }

            swap(items, offset, i);
            recurse(items, offset + 1, res, hasRepeatingElements);
            swap(items, offset, i);
        }
    }

    private static void add(int[] items, List<List<Integer>> res) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(items).forEach(list::add);
        res.add(list);
    }

    private static void swap(int[] items, int left, int right) {
        int tmp = items[left];
        items[left] = items[right];
        items[right] = tmp;
    }
}
