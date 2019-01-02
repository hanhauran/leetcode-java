package leetcode.code800;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/31 17:18
 */

public class Code783 {
    public int minDiffInBST(TreeNode root) {
        result = Integer.MAX_VALUE;
        helper(root);
        return result;
    }

    private int result = Integer.MAX_VALUE;
    private TreeNode pre = null;

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);
        if (pre != null) {
            result = Math.min(node.val - pre.val, result);
        }
        pre = node;
        helper(node.right);
    }
}
