package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        if (items == null || items.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        bfs(items, 0, res);
        return res;
    }

    private static void bfs(int[] items, int offset, List<List<Integer>> res) {
        if (offset == items.length) {
            List<Integer> list = new ArrayList<>();
            Arrays.stream(items).forEach(list::add);
            res.add(list);
            return;
        }

        for (int i = offset; i < items.length; i++) {
            swap(items, offset, i);
            bfs(items, offset + 1, res);
            swap(items, offset, i);
        }
    }

    private static void swap(int[] items, int left, int right) {
        int tmp = items[left];
        items[left] = items[right];
        items[right] = tmp;
    }
}
