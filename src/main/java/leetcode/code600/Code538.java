package leetcode.code600;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/6 20:00
 */

public class Code538 {
    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode node, int plus) {
        if (node == null) {
            return 0;
        }

        int right = convert(node.right, plus);
        int left = convert(node.left, plus + right + node.val);
        int result = right + left + node.val;
        node.val = plus + right + node.val;
        return result;
    }
}
