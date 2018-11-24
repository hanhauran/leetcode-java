package leetcode.code300;

import leetcode.TreeNode;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        } else {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
        }

        return root;
    }
}
