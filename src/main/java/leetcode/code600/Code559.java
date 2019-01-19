package leetcode.code600;

import leetcode.MultiTreeNode;

import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/10 14:02
 */

public class Code559 {
    @SuppressWarnings("all")
    private static class Node extends MultiTreeNode {
        public Node() {
            super();
        }

        public Node(int val, List<Node> children) {
            super(val, children);
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth((Node) root.children.get(i)));
        }
        return 1 + max;
    }


}
