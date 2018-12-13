package leetcode.code700;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/12 18:52
 */

public class Code669 {
    public TreeNode trimBST(TreeNode root, int l, int r) {
        if (root == null) {
            return null;
        }

        if (root.val < l) {
            return trimBST(root.right, l, r);
        } else if (root.val > r) {
            return trimBST(root.left, l, r);
        } else {
            root.left = trimBST(root.left, l, r);
            root.right = trimBST(root.right, l, r);
            return root;
        }
    }
}
