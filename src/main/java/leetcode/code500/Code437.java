package leetcode.code500;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/11/30 20:57
 */

public class Code437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return part(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int part(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum -= root.val;

        if (sum == 0) {
            return 1 + part(root.left, sum) + part(root.right, sum);
        } else {
            return part(root.left, sum) + part(root.right, sum);
        }
    }
}
