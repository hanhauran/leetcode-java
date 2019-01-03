package leetcode.code900;

import annotation.Level;
import annotation.Levels;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/3 10:03
 */

@Level(Levels.EASY)
public class Code872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        toList(root1, l1);
        toList(root2, l2);

        return l1.equals(l2);
    }

    private void toList(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        toList(node.left, res);
        if (node.left == null && node.right == null) {
            res.add(node.val);
        }
        toList(node.right, res);
    }

    public static void main(String[] args) {
        Code872 code = new Code872();
        List<Integer> list = new ArrayList<>();
        TreeNode.EXAMPLE2.list2(list);
        System.out.println(list);
        list.clear();
        code.toList(TreeNode.EXAMPLE2, list);
        System.out.println(list);
    }
}
