package leetcode.code600;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author hr.han
 * @date 2018/12/3 14:57
 */

public class Code501 {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {
            TreeNode cur = queue.remove();
            map.put(cur.val, map.containsKey(cur.val) ? map.get(cur.val) + 1 : 1);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        if (list.size() == 1) {
            return new int[]{list.get(list.size() - 1).getKey()};
        }

        System.out.println(list);

        List<Integer> result = new ArrayList<>();
        result.add(list.get(list.size() - 1).getKey());
        int count = list.get(list.size() - 1).getValue();
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i).getValue() == count) {
                result.add(list.get(i).getKey());
            } else {
                break;
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        Code501 code = new Code501();
        System.out.println(Arrays.toString(code.findMode(node1)));
    }
}
