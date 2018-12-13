package leetcode.code700;

import annotation.Fucked;
import annotation.Unsolved;
import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/13 11:00
 */

@Unsolved
@Fucked
public class Code687 {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return max;
    }

    private int helper(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        max = Math.max(max, left + right);
        if (node.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
