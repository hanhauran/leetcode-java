package leetcode.code600;

import leetcode.TreeNode;

import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/5 20:41
 */

public class Code530 {
    public int getMinimumDifference(TreeNode root) {
        return 0;

//        if (root == null) {
//            return Integer.MAX_VALUE;
//        }
//
//        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
//        if (root.left != null) {
//            left = root.val - root.left.val;
//        }
//        if (root.right != null) {
//            right = root.right.val - root.val;
//        }
//        return Math.min(Math.min(left, right), Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
    }

    public static void main(String[] args) {
        Code530 code = new Code530();
        TreeNode.EXAMPLE.print2();
    }
}
