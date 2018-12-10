package leetcode.code600;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/9 19:38
 */

public class Code543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(depth(root.left) + depth(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
