package leetcode.code200;

import leetcode.TreeNode;

/**
 * @author ihhr
 * @date 2018/10/24
 */

public class Code104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
