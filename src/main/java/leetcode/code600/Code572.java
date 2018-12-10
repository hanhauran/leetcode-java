package leetcode.code600;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/10 14:53
 */

public class Code572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return part(s, t) | (s != null && isSubtree(s.left, t)) | (s != null && isSubtree(s.right, t));
    }

    private boolean part(TreeNode cur, TreeNode target) {
        if (cur == null && target == null) {
            return true;
        }

        if (cur == null || target == null) {
            return false;
        }

        if (cur.val != target.val) {
            return false;
        }

        return part(cur.left, target.left) && part(cur.right, target.right);
    }

    public static void main(String[] args) {
        Code572 code = new Code572();
//        TreeNode node = new TreeNode(3);
//        node.left =  new TreeNode(4);
//        node.right = new TreeNode(5);
//        node.left.left = new TreeNode(1);
//        node.left.right = new TreeNode(2);
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);

        TreeNode target = new TreeNode(4);
        target.left = new TreeNode(1);
        target.right = new TreeNode(2);

        System.out.println(code.isSubtree(node, target));
    }
}
