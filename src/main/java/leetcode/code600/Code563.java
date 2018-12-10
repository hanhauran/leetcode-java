package leetcode.code600;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/10 14:21
 */

public class Code563 {
    private int res = 0;

    public int findTilt(TreeNode root) {
        res = 0;
        if (root == null) {
            return res;
        }

        part(root);
        return res;
    }

    private int part(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = part(node.left);
        int right = part(node.right);
        res += Math.abs(left - right);

        return node.val + left + right;
    }
}
