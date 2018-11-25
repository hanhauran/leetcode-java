package leetcode.code300;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = findAncestors(root, p);
        List<TreeNode> ql = findAncestors(root, q);

        return getCommonAncestor(pl, ql);
    }

    private TreeNode getCommonAncestor(List<TreeNode> list1, List<TreeNode> list2) {
        int index = 0;
        TreeNode result = null;
        while (index < list1.size() && index < list2.size()) {
            if (list1.get(index).val == list2.get(index).val) {
                result = list1.get(index++);
            } else {
                break;
            }
        }
        return result;
    }

    private List<TreeNode> findAncestors(TreeNode root, TreeNode p) {
        List<TreeNode> result = new ArrayList<>();
        while (true) {
            result.add(root);
            if (p.val > root.val) {
                root = root.right;
            } else if (p.val < root.val) {
                root = root.left;
            } else {
                result.add(root);
                break;
            }
        }
        return result;
    }
}
