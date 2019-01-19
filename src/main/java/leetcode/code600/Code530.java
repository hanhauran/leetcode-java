package leetcode.code600;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/5 20:41
 */

public class Code530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // this method is in TreeNode
        root.list2(list);

        int depth = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int tmp = Math.abs(list.get(i) - list.get(i + 1));
            if (tmp < depth) {
                depth = tmp;
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        TreeNode.EXAMPLE.list2(list);
        System.out.println(list);
    }
}
