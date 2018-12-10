package leetcode.code600;

import leetcode.MultiTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/10 17:18
 */

public class Code590 {
    private static class Node extends MultiTreeNode {
        public Node() {
            super();
        }

        public Node(int val, List children) {
            super(val, children);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        part(root, res);
        return res;
    }

    private void part(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.children == null || root.children.isEmpty()) {
            list.add(root.val);
            return;
        }
        for (Object node : root.children) {
            if (node == null) {
                continue;
            }
            part((Node) node, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        Code590 code = new Code590();

        Node node = new Node(1, null);
        node.children = new ArrayList();
        node.children.add(new Node(3, null));
        node.children.add(new Node(2, null));
        node.children.add(new Node(4, null));
        ((Node) node.children.get(0)).children = new ArrayList();
        ((Node) node.children.get(0)).children.add(new Node(5, null));
        ((Node) node.children.get(0)).children.add(new Node(6, null));

        System.out.println(code.postorder(node));
    }
}
