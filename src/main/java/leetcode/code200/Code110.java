package leetcode.code200;

import leetcode.TreeNode;

/**
 * @author ihhr
 * @date 2018/10/25
 */

public class Code110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int delta = Math.abs(depth(root.left) - depth(root.right));
        if (delta <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int depth(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        return Math.max(depth(cur.left), depth(cur.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = depth2(root.left);
        int right = depth2(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    private int depth2(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        int left = depth2(cur.left);
        int right = depth2(cur.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
