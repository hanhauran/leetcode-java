package leetcode.code200;

import leetcode.TreeNode;

/**
 * @author ihhr
 * @date 2018/10/25
 */

public class Code112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return part(root, sum);
    }

    private boolean part(TreeNode cur, int sum) {
        if (cur.left == null && cur.right == null) {
            return cur.val == sum;
        } else if (cur.left == null) {
            return part(cur.right, sum - cur.val);
        } else if (cur.right == null) {
            return part(cur.left, sum - cur.val);
        } else {
            return part(cur.left, sum - cur.val) || part(cur.right, sum - cur.val);
        }
    }
}
