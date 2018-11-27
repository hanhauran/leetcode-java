package leetcode.code200;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ihhr
 * @date 2018/10/24
 */

public class Code101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode left = deque.removeFirst();
            TreeNode right = deque.removeLast();
            if (left == null && right == null) {
            } else if (left == null || right == null) {
                return false;
            } else if (left.val == right.val) {
                deque.offerFirst(left.right);
                deque.offerFirst(left.left);
                deque.offerLast(right.left);
                deque.offerLast(right.right);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricPart(root.left, root.right);
    }

    private boolean isSymmetricPart(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isSymmetricPart(left.left, right.right) && isSymmetricPart(left.right, right.left);
        }

        return false;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(null);
        deque.offerLast(1);
        System.out.println(deque);
    }
}
