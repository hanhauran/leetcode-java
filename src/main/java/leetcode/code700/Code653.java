package leetcode.code700;

import leetcode.TreeNode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hr.han
 * @date 2018/12/11 16:57
 */

public class Code653 {
    public boolean findTarget(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set2(root, set);
        for (int item : set) {
            if (set.contains(k - item) && item != (k - item)) {
                return true;
            }
        }
        return false;
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

    public static void main(String[] args) {
        Code653 code = new Code653();
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(-1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(-3);
        node.right.right = new TreeNode(4);
        System.out.println(code.findTarget(node, -4));
    }
}
