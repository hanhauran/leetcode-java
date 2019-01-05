package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;
import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2019/1/5 15:06
 */

@Level(Levels.EASY)
public class Code965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.val != root.left.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.val != root.right.val) {
                return false;
            }
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
