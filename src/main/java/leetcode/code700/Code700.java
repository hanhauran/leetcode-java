package leetcode.code700;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/13 12:29
 */

public class Code700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val == val) {
            return root;
        } else {
            return searchBST(root.right, val);
        }
    }
}
