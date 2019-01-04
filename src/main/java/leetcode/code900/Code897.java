package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;
import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2019/1/4 20:28
 */

@Level(Levels.EASY)
public class Code897 {
    public TreeNode increasingBST(TreeNode root) {
        node = null;
        tmp = null;
        helper(root);
        return node;
    }

    private TreeNode node = null;
    private TreeNode tmp = null;
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        if (node == null) {
            node = new TreeNode(root.val);
            tmp = node;
        } else {
            tmp.right = new TreeNode(root.val);
            tmp = tmp.right;
        }
        helper(root.right);
    }
}
