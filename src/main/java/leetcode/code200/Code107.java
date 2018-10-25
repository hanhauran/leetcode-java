package leetcode.code200;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author ihhr
 * @date 2018/10/24
 */

public class Code107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            System.out.println(queue);
            TreeNode cur = queue.remove();
            if (cur == null) {
                queue.offer(null);
                result.add(tmp);
                if (queue.size() == 1) {
                    break;
                }
                tmp = new ArrayList<>();
            } else {
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }


        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Code107 code = new Code107();

        TreeNode[] nodes = new TreeNode[5];
        int[] vals = {3,9,20,15,7};
        for (int i = 0; i < 5; i++) {
            nodes[i] = new TreeNode(vals[i]);
        }

        TreeNode root = nodes[0];
        root.left = nodes[1];
        root.right = nodes[2];
        root.right.left = nodes[3];
        root.right.right = nodes[4];

        System.out.println(code.levelOrderBottom(root));
    }
}
