package leetcode.code300;

import com.sun.org.apache.bcel.internal.classfile.Code;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code257 {
    public List<String> binaryTreePaths(TreeNode root) {
        return part(root);
    }

    private List<String> part(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        if (node.left == null && node.right == null) {
            return Collections.singletonList(String.valueOf(node.val));
        }

        List<String> res = new ArrayList<>();

        if (node.left != null) {
            List<String> left = part(node.left);
            left.forEach(s -> res.add(node.val + "->" + s));
        }

        if (node.right != null) {
            List<String> right = part(node.right);
            right.forEach(s -> res.add(node.val + "->" + s));
        }

        return res;
    }

    public static void main(String[] args) {
        Code257 code = new Code257();
        System.out.println(code.binaryTreePaths(TreeNode.EXAMPLE));
    }
}
