package leetcode.code500;

import leetcode.MultiTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/11/30 20:29
 */

public class Code429 {

    static class Node extends MultiTreeNode {
        public Node() {
            super();
        }

        public Node(int val, List<MultiTreeNode> children) {
            super(val, children);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Node> children = part(result, Collections.singletonList(root));
        while (! children.isEmpty()) {
            children = part(result, children);
        }
        return result;
    }

    private List<Node> part(List<List<Integer>> result, List<Node> cur) {
        List<Node> returnNodes = new ArrayList<>();
        List<Integer> add = new ArrayList<>();
        for (Node node : cur) {
            if (node.children != null && !node.children.isEmpty()) {
                returnNodes.addAll(node.children);
            }
            add.add(node.val);
        }
        result.add(add);
        return returnNodes;
    }

}
