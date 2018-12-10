package leetcode.code600;

import annotation.Unsolved;
import leetcode.QuadTreeNode;

/**
 * @author hr.han
 * @date 2018/12/9 19:53
 */

@Unsolved
public class Code558 {
    static class Node extends QuadTreeNode {
        public Node() {
            super();
        }

        public Node(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
            super(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public Node intersect(Node qt1, Node qt2) {
        Node qt = new Node();
        part(qt, qt1, qt2);
        return qt;
    }

    private void part(QuadTreeNode qt, QuadTreeNode qt1, QuadTreeNode qt2) {
        if (qt1 == null || qt2 == null) {
            return;
        }

        if (qt1.isLeaf && qt2.isLeaf) {
            qt.isLeaf = true;
            qt.val = qt1.val | qt2.val;
            return;
        }

        if (qt1.isLeaf) {
            if (qt1.val) {
                qt.isLeaf = true;
                qt.val = true;
                return;
            } else {
                qt.topLeft = qt2.topLeft;
                qt.topRight = qt2.topRight;
                qt.bottomLeft = qt2.bottomLeft;
                qt.bottomRight = qt2.bottomRight;
                return;
            }
        }

        if (qt2.isLeaf) {
            if (qt2.val) {
                qt.isLeaf = true;
                qt.val = true;
                return;
            } else {
                qt.topLeft = qt1.topLeft;
                qt.topRight = qt1.topRight;
                qt.bottomLeft = qt1.bottomLeft;
                qt.bottomRight = qt1.bottomRight;
                return;
            }
        }

        qt.topLeft = new Node();
        qt.topRight = new Node();
        qt.bottomLeft = new Node();
        qt.bottomRight = new Node();
        part(qt.topLeft, qt1.topLeft, qt2.topLeft);
        part(qt.topRight, qt1.topRight, qt2.topRight);
        part(qt.bottomLeft, qt1.bottomLeft, qt2.bottomLeft);
        part(qt.bottomRight, qt1.bottomRight, qt2.bottomRight);
    }
}
