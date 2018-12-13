package leetcode.code700;

import leetcode.TreeNode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hr.han
 * @date 2018/12/12 19:00
 */

public class Code671 {
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        set2(root, set);
        set.pollFirst();
        return set.size() == 0 ? -1 : set.first();
    }

    private void set2(TreeNode node, SortedSet<Integer> set) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            set2(node.left, set);
        }
        set.add(node.val);
        if (node.right != null) {
            set2(node.right, set);
        }
    }
}
