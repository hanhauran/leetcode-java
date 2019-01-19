package leetcode.code600;

import leetcode.MultiTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/10 16:08
 */

public class Code589 {
    @SuppressWarnings("all")
    private static class Node extends MultiTreeNode {
        public Node() {
            super();
        }

        public Node(int val, List children) {
            super(val, children);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        part(root, res);
        return res;
    }

    private void part(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return;
        }
        for (Object node : root.children) {
            if (node == null) {
                continue;
            }
            part((Node) node, list);
        }
    }
}
