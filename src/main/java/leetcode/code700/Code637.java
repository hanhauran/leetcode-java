package leetcode.code700;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/11 16:05
 */

public class Code637 {
    public List<Double> averageOfLevels2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> res = new ArrayList<>();
        while (! queue.isEmpty()) {
            int size = queue.size();
            double sum = 0D;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / size);
        }

        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        TreeNode tmp = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(tmp);

        List<Double> res = new ArrayList<>();
        List<Double> list = new ArrayList<>();
        boolean flag = false;
        while (! queue.isEmpty()) {
            if (flag) {
                queue.offer(tmp);
                flag = false;
            }
            TreeNode cur = queue.poll();
            if (tmp.equals(cur)) {
                res.add(part(list));
                list.clear();
                flag = true;
                continue;
            }

            list.add((double) cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return res;
    }

    private double part(List<Double> list) {
        double res = 0D;
        for (double item : list) {
            res += item;
        }
        return res / list.size();
    }

    public static void main(String[] args) {
        Code637 code = new Code637();
        System.out.println(code.averageOfLevels2(TreeNode.EXAMPLE));
    }
}
